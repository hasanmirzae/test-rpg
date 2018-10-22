package com.example;

import com.example.controllers.FrontPageController;
import com.example.pages.FrontPage;
import com.example.pages.MenuCmds;
import com.example.pages.Page;
import com.example.services.PageManager;
import com.example.utils.IOUtil;

import java.io.IOException;

public class AppGui implements Runnable{

    private Page currentPage;
    private Page homePage;
    private MenuCmds menuCmd = MenuCmds.HELP;
    private PageManager pageManager;

    private AppGui(){ }

    public AppGui(PageManager pageManager){
        this.pageManager = pageManager;
        init();
    }

    private void init(){
        printLogo();
        homePage = new FrontPage(new FrontPageController(this),this);
        currentPage = homePage;
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public void openPage(String key){
        if (!pageManager.has(key)){
            System.out.println("Page not found! "+key);
        }else{
            currentPage = pageManager.getPage(key);
        }
    }



    @Override public void run() {

        while (menuCmd != MenuCmds.EXIT){
            currentPage.showMenu();
            currentPage.accept(IOUtil.prompt("Enter menu item"));
        }
        goodBye();
    }



    private static void goodBye() {
        System.out.println("Good bye! See you soon :)");
    }



    private static void printLogo() {
        try {
            IOUtil.printTxtTile("logo.txt");
        } catch (IOException e) {
            System.out.println("Welcome to RPGs");
        }
    }

    public void exit(){
        this.menuCmd = MenuCmds.EXIT;
    }

    public void goHome() {
        openPage(FrontPage.KEY);
    }

    public void initPage(String key, Page page) {
        pageManager.initPage(key,page);
    }

    public boolean initializedPage(String key) {
        return pageManager.has(key);
    }
}
