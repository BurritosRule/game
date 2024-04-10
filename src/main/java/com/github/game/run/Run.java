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
import com.github.game.ui.ActionExecuter;
import com.github.game.ui.InfoBannerRenderer;
import com.github.game.ui.MenuRenderer;
import com.github.game.ui.UiBuilder;
import com.github.game.world.Action;
import com.github.game.world.TowerImpl;
import com.github.game.world.Umbrus;

public class Run {

  public static void main(String[] args) throws IOException {

    // TowerImpl castleTower = new TowerImpl("Castle Tower", 10);
    Umbrus umbrus = new Umbrus();
    Player player = new PlayerImpl("Hero", umbrus);

    MenuController menuController = new MenuController();

    MenuFactory menuFactory = new MenuFactory(menuController, player);
    Menu menu = menuFactory.getMenu(umbrus);

    menuController.addMenu(menu);

    UiBuilder ui = new UiBuilder();
    Terminal terminal = ui.createTerminal();

    DefaultParser parser = ui.createParser();
    LineReader reader = ui.createReader(terminal, parser);

    InfoBannerRenderer infoBannerRenderer = new InfoBannerRenderer(terminal);
    MenuRenderer menuRenderer = new MenuRenderer(terminal);
    ActionExecuter actionExecuter = new ActionExecuter(reader);

    Map<String, Action> actions = new HashMap<>();

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