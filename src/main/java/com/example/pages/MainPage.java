package com.example.pages;

import com.example.controllers.Controller;

public class MainPage extends AbstractPage{



    public MainPage(Controller controller) {
        super(controller);
    }

    @Override public void onKeyPress(char key) {
        controller.handleRequest(this, key);
    }

    @Override protected void onShow() {
        showMenu();

    }


    @Override public void showMenu() {
        System.out.println(new MenuView.Builder()
                .addItem("a","Command a")
                .addItem("b","Command b")
                .addItem("c","Show main page")
                .addItem("e","Exit")
                .build()
        );
    }

    @Override public PageIDs getPageId() {
        return PageIDs.MAIN;
    }
}
