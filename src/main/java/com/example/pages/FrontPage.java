package com.example.pages;

import com.example.controllers.Controller;
import com.example.controllers.FrontPageController;
import com.example.AppGui;
import com.example.controllers.GamesListController;

public class FrontPage  extends AbstractPage{

    public static final String KEY = "FRONT_PAGE";

    {
       appGui.initPage(GamesListPage.KEY, new GamesListPage(new GamesListController(appGui),appGui));

    }


    public FrontPage(Controller controller, AppGui appGui) {
        super(controller, appGui);
        appGui.initPage(KEY,this);
    }



    @Override public void showMenu() {
        System.out.println(new MenuView.Builder()
                .addItem(FrontPageController.CMD_LIST_GAME,"List games")
                .addItem(FrontPageController.CMD_EXIT,"Exit application")
                .withTitle("Home")
                .build()
        );
    }

    @Override public void accept(String input) {
        controller.handleRequest(input);
    }

    @Override public String name() {
        return "Home";
    }


}
