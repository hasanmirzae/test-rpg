package com.example.controllers;

import com.example.pages.GamesListPage;
import com.example.services.AppGui;
import com.example.services.FrontPageService;
import com.example.services.GamesListService;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class FrontPageController implements Controller {

    public final static String CMD_LIST_GAME = "1";
    public final static String CMD_EXIT = "2";
    private AppGui appGui;
    private FrontPageService frontPageService;

    private Map<String, Consumer<String>> handlers;


    {
        //Init handlers
        handlers = new HashMap<>(1);
        handlers.put(CMD_LIST_GAME,cmd -> {
            if (!appGui.initializedPage(GamesListPage.KEY)){
                appGui.initPage(GamesListPage.KEY, new GamesListPage(new GamesListController(appGui,new GamesListService()),appGui));
            }
            appGui.openPage(GamesListPage.KEY);
        });
        handlers.put(CMD_EXIT,cmd -> appGui.exit());
    }



    private FrontPageController(){}

    public FrontPageController(AppGui appGui, FrontPageService frontPageService) {
        this.appGui = appGui;
        this.frontPageService = frontPageService;
    }



    @Override public void handleRequest(String input) {

        if (!handlers.containsKey(input)){
            throw new UnsupportedOperationException("Unsupported command "+input);
        }
        handlers.get(input).accept(input);
    }



}
