package com.github.game.run;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.UserInterruptException;
import org.jline.reader.impl.DefaultParser;
import org.jline.terminal.Terminal;

import com.github.game.menu.Menu;
import com.github.game.menu.MenuController;
import com.github.game.menu.MenuFactory;
import com.github.game.player.Player;
import com.github.game.player.PlayerImpl;
import com.github.game.state.AutoSaveListener;
import com.github.game.state.GameState;
import com.github.game.state.GameStatePersistence;
import com.github.game.ui.ActionExecuter;
import com.github.game.ui.InfoBannerRenderer;
import com.github.game.ui.MenuRenderer;
import com.github.game.ui.UiBuilder;
import com.github.game.world.Action;
import com.github.game.world.LocationFactory;
import com.github.game.world.Umbrus;
import com.github.game.world.World;
import com.github.game.world.PersistableRegistry;

public class Run {

  public static void main(String[] args) throws IOException {

    UiBuilder ui = new UiBuilder();
    Terminal terminal = ui.createTerminal();

    DefaultParser parser = ui.createParser();
    LineReader reader = ui.createReader(terminal, parser);

    // Register PlayerState for persistence
    com.github.game.player.PlayerState playerState = new com.github.game.player.PlayerState(
        com.github.game.world.LocationName.UMBRUS);
    // Create and register WindingPath before loading
    com.github.game.world.WindingPath windingPath = new com.github.game.world.WindingPath();

    LocationFactory locationFactory = new LocationFactory();
    World world = new World(locationFactory);

    // Register all persistables before loading so deserialization works
    PersistableRegistry.registerAll(GameState.getInstance());

    // Load persisted state (will update playerState and location states)
    GameStatePersistence.loadFromFile(GameState.getInstance(), "savegame.json", reader);
    new AutoSaveListener("savegame.json");

    // Load all registered objects from unified save file
    com.github.game.state.GamePersistence.loadGame();

    // Use the registered PlayerState and WindingPath from GameState
    playerState = (com.github.game.player.PlayerState) GameState.getInstance().getState("PlayerState");
    windingPath = (com.github.game.world.WindingPath) GameState.getInstance().getState("WindingPath");

    Player player = new PlayerImpl("Hero", null);
    if (playerState.getCurrentLocation() != null) {
      player.setCurrentLocation(world.getLocation(playerState.getCurrentLocation()));
    } else {
      player.setCurrentLocation(world.getLocation(com.github.game.world.LocationName.UMBRUS));
    }

    MenuController menuController = new MenuController();
    MenuFactory menuFactory = new MenuFactory(menuController, player, world);
    // Use player's current location for menu creation
    Menu menu = menuFactory.getMenu(player.getCurrentLocation());
    menuController.addMenu(menu);

    InfoBannerRenderer infoBannerRenderer = new InfoBannerRenderer(terminal);
    MenuRenderer menuRenderer = new MenuRenderer(terminal);
    ActionExecuter actionExecuter = new ActionExecuter(reader);

    Map<String, Action> actions = new HashMap<>();

    // Load Umbrus state from file using new persistence system
    com.github.game.world.Umbrus umbrus = (com.github.game.world.Umbrus) world
        .getLocation(com.github.game.world.LocationName.UMBRUS);
    com.github.game.world.UmbrusFilePersistence.loadUmbrusFromFile(umbrus);

    // Ensure savegame.json exists on first run
    java.nio.file.Path savePath = java.nio.file.Paths.get("savegame.json");
    if (!java.nio.file.Files.exists(savePath)) {
      com.github.game.state.GamePersistence.saveGame();
    }

    // If you have a Tower instance to persist, load its state as well (example):
    // com.github.game.world.TowerImpl tower = ...;
    // com.github.game.world.TowerFilePersistence.loadTowerFromFile(tower);

    // Optionally, add a shutdown hook to save Umbrus and Tower state:
    // Runtime.getRuntime().addShutdownHook(new Thread(() -> {
    // com.github.game.world.UmbrusFilePersistence.saveUmbrusToFile(umbrus);
    // com.github.game.world.TowerFilePersistence.saveTowerToFile(tower);
    // }));

    while (true) {
      try {
        infoBannerRenderer.render(player);
        Menu currentMenu = menuController.peekLastMenu();
        if (currentMenu == null) {
          terminal.writer().println("No menu to display. Exiting game loop.");
          break;
        }
        actions = menuRenderer.render(currentMenu);
        actionExecuter.executeAction(actions);
      } catch (UserInterruptException e) {

      } catch (EndOfFileException e) {
        return;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    // Optionally, save player state on shutdown or autosave using:
    // com.github.game.player.PlayerStateFilePersistence.savePlayerStateToFile(playerState);
  }

  // After player location changes, update PlayerState for persistence
  // Example: when changing location, call
  // playerState.setCurrentLocation(newLocationName);
  // You may want to wire this into your location change logic or event system.
}