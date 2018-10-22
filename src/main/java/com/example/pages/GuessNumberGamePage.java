package com.example.pages;

import com.example.controllers.Controller;
import com.example.controllers.GuessNumberGameController;
import com.example.AppGui;

public class GuessNumberGamePage extends AbstractPage {

    public static final String KEY = "GUESS_NUMBER_PAGE";

    public GuessNumberGamePage(Controller controller, AppGui appGui) {
        super(controller, appGui);
        appGui.initPage(KEY,this);
    }


    @Override public void showMenu() {

        System.out.println(new MenuView.Builder()
                .addItem(GuessNumberGameController.CMD_START_NEW,"Start new game")
                .addItem(GuessNumberGameController.CMD_RESUME,"Resume game ...")
                .addItem(GuessNumberGameController.CMD_SAVE,"Save game ...")
                .addItem(GuessNumberGameController.CMD_EXIT,"Exit")
                .withTitle(name())
                .build()
        );


    }


    @Override public String name() {
        return "My first game";
    }
}
