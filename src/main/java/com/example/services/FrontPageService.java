package com.example.services;

import com.example.pages.Page;
import com.example.pages.PageIDs;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class FrontPageService {

    private Map<String, Consumer<String>> handlers;


    {
        //Init handlers
        handlers = new HashMap<>(1);
        handlers.put(null,cmd -> System.out.println("Handling command: "+ cmd));
        handlers.put(getKey("2"),cmd -> System.out.println("Handling command: "+ cmd));
    }


    public void handleRequest(String input) {
        String key = getKey(input);
        if (!handlers.containsKey(key)){
            throw new UnsupportedOperationException("Unsupported command "+input);
        }

        handlers.get(key).accept(input);
    }

    private String getKey(String cmd){
        return PageIDs.MAIN.name()+"_"+cmd;
    }

}
