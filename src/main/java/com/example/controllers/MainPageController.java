package com.example.controllers;

import com.example.pages.Page;
import com.example.pages.PageIDs;
import com.example.services.PageManager;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class MainPageController implements Controller {

    private Map<String, Consumer<Character>> handlers;
    private PageManager pageManager;

    private MainPageController(){}

    public MainPageController(PageManager pageManager) {
        this.pageManager = pageManager;
    }

    {
        //Init handlers
        handlers = new HashMap<>(1);
        handlers.put(getKey('a'),cmd -> System.out.println("Handling command: "+ cmd));
        handlers.put(getKey('b'),cmd -> System.out.println("Handling command: "+ cmd));
        handlers.put(getKey('c'),cmd -> pageManager.openPage(PageIDs.MAIN));
        handlers.put(getKey('e'),cmd -> pageManager.exit());
    }


    @Override public void handleRequest(Page page, char cmd) {
        String key = getKey(cmd);
        if (!handlers.containsKey(key)){
            throw new UnsupportedOperationException("Unsupported command "+cmd);
        }

        handlers.get(key).accept(cmd);
    }

    private String getKey(char cmd){
        return PageIDs.MAIN.name()+"_"+cmd;
    }

}
