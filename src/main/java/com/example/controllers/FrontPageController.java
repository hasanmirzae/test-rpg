package com.example.controllers;

import com.example.AppGui;
import com.example.pages.GamesListPage;

import java.util.HashMap;
import java.util.Map;

public class FrontPageController implements Controller {

    public final static String CMD_LIST_GAME = "1";
    public final static String CMD_EXIT = "2";
    private AppGui appGui;

    private Map<String, Runnable> handlers = new HashMap<>(3);

    private FrontPageController(){}

    public FrontPageController(AppGui appGui) {
        this.appGui = appGui;
        init();
    }

    private void init(){
        //Init handlers
        handlers.put(CMD_LIST_GAME,() -> appGui.openPage(GamesListPage.KEY));
        handlers.put(CMD_EXIT,appGui::exit);
    }

    protected void setHandlers(Map<String, Runnable> handlers){
        this.handlers = handlers;
    }


    @Override public void handleRequest(String input) {

        if (!handlers.containsKey(input)){
            System.out.println("Wrong menu number!");
        }else{
            handlers.get(input).run();
        }

    }



}
