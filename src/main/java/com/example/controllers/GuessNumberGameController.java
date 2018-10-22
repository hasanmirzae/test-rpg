package com.example.controllers;

import com.example.services.AppGui;
import com.example.games.GuessNumberGame;

import java.util.HashMap;
import java.util.Map;

public class GuessNumberGameController implements Controller {

    public final static String CMD_START_NEW = "1";
    public final static String CMD_RESUME = "2";
    public final static String CMD_SAVE = "3";
    public final static String CMD_EXIT = "4";
    private AppGui appGui;
    private GuessNumberGame guessNumberGame;

    private Map<String, Runnable> handlers;


    {
        //Init handlers
        handlers = new HashMap<>(1);
        handlers.put(CMD_START_NEW,() -> guessNumberGame.startNewGame());
        handlers.put(CMD_RESUME,() -> guessNumberGame.resume());
        handlers.put(CMD_SAVE,() -> guessNumberGame.save());
        handlers.put(CMD_EXIT,() -> appGui.goHome());
    }



    private GuessNumberGameController(){}

    public GuessNumberGameController(AppGui appGui, GuessNumberGame guessNumberGame) {
        this.appGui = appGui;
        this.guessNumberGame = guessNumberGame;
    }



    @Override public void handleRequest(String input) {

        if (!handlers.containsKey(input)){
            System.out.println("Wrong command! Please choose a command from the menu.");
        }
        handlers.get(input).run();

    }



}
