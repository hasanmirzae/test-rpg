package com.example.controllers;

import com.example.services.AppGui;
import com.example.services.GuessNumberGameService;

import java.util.HashMap;
import java.util.Map;

public class GuessNumberGameController implements Controller {

    public final static String CMD_START_NEW = "1";
    public final static String CMD_RESUME = "2";
    public final static String CMD_EXIT = "3";
    private AppGui appGui;
    private GuessNumberGameService guessNumberGameService;

    private Map<String, Runnable> handlers;


    {
        //Init handlers
        handlers = new HashMap<>(1);
        handlers.put(CMD_START_NEW,() -> guessNumberGameService.startNewGame());
        handlers.put(CMD_RESUME,() -> guessNumberGameService.resume());
        handlers.put(CMD_EXIT,() -> appGui.goHome());
    }



    private GuessNumberGameController(){}

    public GuessNumberGameController(AppGui appGui, GuessNumberGameService guessNumberGameService) {
        this.appGui = appGui;
        this.guessNumberGameService = guessNumberGameService;
    }



    @Override public void handleRequest(String input) {

        if (!handlers.containsKey(input)){
            System.out.println("Wrong command! Please choose a command from the menu.");
        }
        handlers.get(input).run();

    }



}
