package com.example.services;

import com.example.pages.MainPage;
import com.example.pages.MenuCmds;
import com.example.pages.Page;
import com.example.pages.PageIDs;
import com.example.controllers.MainPageController;
import com.example.utils.IOUtil;

public class PageManager implements Runnable{

    private Page currentPage;
    private MenuCmds menuCmd = MenuCmds.HELP;




    public Page getCurrentPage() {
        return currentPage;
    }


    public void openPage(PageIDs pageid){

        switch (pageid){
            case MAIN: currentPage = new MainPage(new MainPageController(this));
            break;
            default:
                System.out.println("Page not implemented!");
        }
    }



    @Override public void run() {
        printLogo();
        currentPage = new MainPage(new MainPageController(this));
        while (menuCmd != MenuCmds.EXIT){

            System.out.println("Enter command: ");
            String input = IOUtil.readInput();
            char cmd = input == null ? '?' : input.charAt(0);
            currentPage.onKeyPress(cmd);

        }
        goodBye();
    }

    private static void goodBye() {
        System.out.println("Good bye! See you soon :)");

    }



    private static void printLogo() {
        System.out.println("Welcome to my game!");
    }

    public void exit(){
        this.menuCmd = MenuCmds.EXIT;
    }
}
