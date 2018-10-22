package com.example.controllers;

import com.example.AppGui;
import com.example.pages.GuessNumberGamePage;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/*
 * To handle requests from @GamesListPage.
 */
public class GamesListController implements Controller {

    public final static String CMD_GUESS_NUMBER_GAME = "1";
    public final static String CMD_EXIT = "2";
    private AppGui appGui;

    private Map<String, Consumer<String>> handlers;


    {
        //Init handlers
        handlers = new HashMap<>(1);
        handlers.put(CMD_GUESS_NUMBER_GAME, cmd -> appGui.openPage(GuessNumberGamePage.KEY));
        handlers.put(CMD_EXIT,cmd -> appGui.goHome());
    }



    private GamesListController(){}

    public GamesListController(AppGui appGui) {
        this.appGui = appGui;
    }



    @Override public void handleRequest(String input) {

        if (!handlers.containsKey(input)){
            System.out.println("Wrong menu item!");
        }else {
            handlers.get(input).accept(input);
        }
    }



}
