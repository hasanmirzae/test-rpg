package com.example.services;

import com.example.pages.Page;

import java.util.HashMap;
import java.util.Map;

public class PageManager {

    private Map<String,Page> pages = new HashMap<>();

    public void initPage(String key, Page page){
        this.pages.put(key, page);
    }

    public Page getPage(String key){
        return this.pages.get(key);
    }



    public boolean has(String key) {
        return this.pages.containsKey(key);
    }
}
