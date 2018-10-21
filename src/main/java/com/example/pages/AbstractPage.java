package com.example.pages;

import com.example.controllers.Controller;

public abstract class AbstractPage implements Page {

    protected Controller controller;

    public AbstractPage(Controller controller){
        this.controller = controller;
        onShow();
    }


    protected abstract void onShow();

}
