package com.example.controllers;

import com.example.games.MyFirstGame;
import com.example.services.AppGui;
import com.example.services.GamesListService;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class GamesListController implements Controller {

    public final static String CMD_MY_FIRST_GAME = "1";
    public final static String CMD_EXIT = "2";
    private AppGui appGui;
    private GamesListService gamesListService;

    private Map<String, Consumer<String>> handlers;


    {
        //Init handlers
        handlers = new HashMap<>(1);
        handlers.put(CMD_MY_FIRST_GAME,cmd -> appGui.openPage(MyFirstGame.KEY));
        handlers.put(CMD_EXIT,cmd -> appGui.goHome());
    }



    private GamesListController(){}

    public GamesListController(AppGui appGui, GamesListService gamesListService) {
        this.appGui = appGui;
        this.gamesListService = gamesListService;
    }



    @Override public void handleRequest(String input) {

        if (!handlers.containsKey(input)){
            throw new UnsupportedOperationException("Unsupported command "+input);
        }

        handlers.get(input).accept(input);

    }



}
