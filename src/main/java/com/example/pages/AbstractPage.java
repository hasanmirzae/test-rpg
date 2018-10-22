package com.example.pages;

import com.example.controllers.Controller;
import com.example.services.AppGui;

public abstract class AbstractPage implements Page {

    protected Controller controller;
    protected AppGui appGui;

    public AbstractPage(Controller controller, AppGui appGui){
        this.controller = controller;
        this.appGui = appGui;
        onShow();
    }

    @Override public void accept(String input) {
        controller.handleRequest(input);
    }

    protected void onShow(){
    }

}
