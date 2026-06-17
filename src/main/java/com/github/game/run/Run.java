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
import com.github.game.player.PlayerState;
import com.github.game.state.AutoSaveListener;
import com.github.game.state.GameState;
import com.github.game.state.GameStatePersistence;
import com.github.game.ui.ActionExecuter;
import com.github.game.ui.InfoBannerRenderer;
import com.github.game.ui.LocationDescriptionRenderer;
import com.github.game.ui.MenuRenderer;
import com.github.game.ui.UiBuilder;
import com.github.game.world.Action;
import com.github.game.world.Location;
import com.github.game.world.LocationFactory;
import com.github.game.world.World;

public class Run {

  public static void main(String[] args) throws IOException {

    UiBuilder ui = new UiBuilder();
    Terminal terminal = ui.createTerminal();

    DefaultParser parser = ui.createParser();
    LineReader reader = ui.createReader(terminal, parser);

    GameStatePersistence.loadFromFile(GameState.getInstance(), "savegame.txt");
    new AutoSaveListener("savegame.txt");

    // Initialize world and location factory
    MenuController menuController = new MenuController();
    LocationFactory locationFactory = new LocationFactory();
    World world = new World(locationFactory);

    // Load or create PlayerState
    PlayerState playerState = (PlayerState) GameState.getInstance().getStateObject("player");
    if (playerState == null) {
      // No saved state, create new player with defaults
      playerState = new PlayerState();
      GameState.getInstance().addStateObject("player", playerState);
    }

    // Get the location object for the saved location (use World to ensure caching)
    Location startLocation = world.getLocation(playerState.getLocationName());

    // Create player with loaded/new state
    Player player = new PlayerImpl(playerState, startLocation);

    MenuFactory menuFactory = new MenuFactory(menuController, player, world);
    Menu menu = menuFactory.getMenu(startLocation);

    menuController.addMenu(menu);

    InfoBannerRenderer infoBannerRenderer = new InfoBannerRenderer(terminal);
    LocationDescriptionRenderer locationDescriptionRenderer = new LocationDescriptionRenderer(terminal);
    MenuRenderer menuRenderer = new MenuRenderer(terminal);
    ActionExecuter actionExecuter = new ActionExecuter(reader);

    Map<String, Action> actions = new HashMap<>();

    while (true) {
      try {
        infoBannerRenderer.render(player);
        // locationDescriptionRenderer.render(location);
        actions = menuRenderer.render(menuController.peekLastMenu());
        actionExecuter.executeAction(actions);
        ;
      } catch (UserInterruptException e) {

      } catch (EndOfFileException e) {
        return;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }
}