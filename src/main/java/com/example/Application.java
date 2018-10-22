package com.example;

import com.example.services.AppGui;
import com.example.utils.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    public static void main (String[] args){
        start();
    }

    private static void start() {
        ExecutorService executorService = null;
        try{
            executorService = Executors.newSingleThreadExecutor();
            executorService.submit(new AppGui())
                           .get();
        }catch (Throwable e){
            Logger.error("Sorry, Application exited unexpectedly :(");
            e.printStackTrace();
            System.exit(1);
        }
        executorService.shutdownNow();
    }


}
