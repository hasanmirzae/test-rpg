package com.example.controllers;

import com.example.services.AppGui;
import com.example.services.MyFirstGameService;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class MyFirstGameController implements Controller {

    public final static String CMD_START_NEW = "1";
    public final static String CMD_RESUME = "2";
    public final static String CMD_EXIT = "3";
    private AppGui appGui;
    private MyFirstGameService myFirstGameService;

    private Map<String, Consumer<String>> handlers;


    {
        //Init handlers
        handlers = new HashMap<>(1);
        handlers.put(CMD_START_NEW,cmd -> myFirstGameService.startNewGame());
        handlers.put(CMD_RESUME,cmd -> myFirstGameService.resume());
        handlers.put(CMD_EXIT,cmd -> appGui.goHome());
    }



    private MyFirstGameController(){}

    public MyFirstGameController(AppGui appGui, MyFirstGameService myFirstGameService) {
        this.appGui = appGui;
        this.myFirstGameService = myFirstGameService;
    }



    @Override public void handleRequest(String input) {

        if (!handlers.containsKey(input)){
            System.out.println("Wrong command! Please choose a command from the menu.");
        }
        handlers.get(input).accept(input);

    }



}
