package com.github.game.run;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.UserInterruptException;
import org.jline.reader.impl.DefaultParser;
import org.jline.terminal.Terminal;

import com.github.game.menu.Menu;
import com.github.game.menu.MenuController;
import com.github.game.menu.MenuFactory;
import com.github.game.menu.MenuUpdater;
import com.github.game.player.Player;
import com.github.game.player.PlayerImpl;
import com.github.game.ui.ActionExecuter;
import com.github.game.ui.InfoBannerRenderer;
import com.github.game.ui.MenuRenderer;
import com.github.game.ui.UiBuilder;
import com.github.game.world.Action;
import com.github.game.world.TowerImpl;

public class Run {

  public static void main(String[] args) throws IOException {

    TowerImpl castleTower = new TowerImpl("Castle Tower", 10);
    Player player = new PlayerImpl("Hero", castleTower);

    MenuFactory menuFactory = new MenuFactory();
    Menu menu = menuFactory.getMenu(castleTower);

    MenuController menuController = new MenuController();
    menuController.addMenu(menu);

    MenuUpdater menuUpdater = new MenuUpdater(menuController);
    menuUpdater.updateMenu(menu);

    UiBuilder ui = new UiBuilder();
    Terminal terminal = ui.createTerminal();

    DefaultParser parser = ui.createParser();
    LineReader reader = ui.createReader(terminal, parser);

    InfoBannerRenderer infoBannerRenderer = new InfoBannerRenderer(terminal);
    MenuRenderer menuRenderer = new MenuRenderer(terminal);
    ActionExecuter actionExecuter = new ActionExecuter(reader);

    Map<String, Action> actions = new HashMap<>();

    // List<Action> additionalActions = new ArrayList<Action>();
    // additionalActions.add(new Action() {

    // @Override
    // public String getKeyword() {
    // return "quit";
    // }

    // @Override
    // public void execute() {
    // System.exit(0);

    // }
    // });

    // menu.addActions(additionalActions);

    List<Action> playerActions = new ArrayList<Action>();

    playerActions.add(new Action() {

      @Override
      public String getKeyword() {
        return "inventory";
      }

      @Override
      public void execute() {
        Menu inventoryMenu = menuFactory.createInventoryMenu();
        menuController.addMenu(inventoryMenu);
        menuUpdater.updateMenu(inventoryMenu);
      }
    });

    playerActions.add(new Action() {

      @Override
      public String getKeyword() {
        return "stats";
      }

      @Override
      public void execute() {
        System.exit(0);

      }

    });

    //menu.addActions(playerActions);

    while (true) {
      try {
        infoBannerRenderer.render(player);
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