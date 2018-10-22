package com.example.games;

import com.example.controllers.Controller;
import com.example.controllers.MyFirstGameController;
import com.example.pages.AbstractPage;
import com.example.pages.MenuView;
import com.example.services.AppGui;

public class MyFirstGame extends AbstractPage implements Game{

    public static final String KEY = "MY_FIRST_GAME";
    public static final String CMD_EXIT = "1";

    public MyFirstGame(Controller controller, AppGui appGui) {
        super(controller, appGui);
        appGui.initPage(KEY,this);
    }


    @Override public void startNewGame() {

    }

    @Override public void save() {

    }

    @Override public void load() {

    }


    @Override public void showMenu() {

        System.out.println(new MenuView.Builder()
                .addItem(MyFirstGameController.CMD_START_NEW,"Start new game")
                .addItem(MyFirstGameController.CMD_RESUME,"Resume game ...")
                .addItem(MyFirstGameController.CMD_EXIT,"Exit")
                .withTitle("My first game")
                .build()
        );


    }


    @Override public String name() {
        return null;
    }
}
