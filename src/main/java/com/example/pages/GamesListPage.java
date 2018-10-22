package com.example.pages;

import com.example.controllers.Controller;
import com.example.controllers.GamesListController;
import com.example.controllers.GuessNumberGameController;
import com.example.services.AppGui;
import com.example.games.GuessNumberGame;

import java.util.ArrayList;
import java.util.List;

public class GamesListPage extends AbstractPage{

    public final static String KEY = "GAME_LIST_PAGE";
    private List<Page> games;

    {
        games = new ArrayList<>();
        GuessNumberGamePage game = new GuessNumberGamePage(new GuessNumberGameController(appGui,new GuessNumberGame()),appGui);
        appGui.initPage(GuessNumberGamePage.KEY,game);
        games.add(game);
    }

    public GamesListPage(Controller controller, AppGui appGui) {
        super(controller, appGui);
        appGui.initPage(KEY, this);
    }



    public List<Page> getGames(){
        return this.games;
    }


    @Override public void showMenu() {
        System.out.println(new MenuView.Builder()
                .addItem(GamesListController.CMD_MY_FIRST_GAME,"My first game")
                .addItem(GamesListController.CMD_EXIT,"Exit")
                .withTitle("All games")
                .build()
        );
    }


    @Override public String name() {
        return "All Games";
    }


}
