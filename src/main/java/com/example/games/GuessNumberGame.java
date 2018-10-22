package com.example.games;

import com.example.controllers.Controller;
import com.example.controllers.GuessNumberGameController;
import com.example.pages.AbstractPage;
import com.example.pages.MenuView;
import com.example.services.AppGui;

public class GuessNumberGame extends AbstractPage {

    public static final String KEY = "MY_FIRST_GAME";

    public GuessNumberGame(Controller controller, AppGui appGui) {
        super(controller, appGui);
        appGui.initPage(KEY,this);
    }


    @Override public void showMenu() {

        System.out.println(new MenuView.Builder()
                .addItem(GuessNumberGameController.CMD_START_NEW,"Start new game")
                .addItem(GuessNumberGameController.CMD_RESUME,"Resume game ...")
                .addItem(GuessNumberGameController.CMD_EXIT,"Exit")
                .withTitle(name())
                .build()
        );


    }


    @Override public String name() {
        return "My first game";
    }
}
