package com.example;

import com.example.utils.Logger;

import java.util.concurrent.Executors;

public class Application {

    public static void main (String[] args){
        try{
            printLogo();
            Executors.newSingleThreadExecutor()
                     .submit(new Menu())
                     .get();
            goodBye();
        }catch (Throwable e){
            Logger.error("Sorry, Application exited unexpectedly :(");
        }

    }

    private static void goodBye() {
        System.out.println("Good bye! See you soon :)");

    }



    private static void printLogo() {
        System.out.println("Welcome to my game!");
    }
}
