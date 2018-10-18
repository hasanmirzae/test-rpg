package com.example;

import com.example.utils.Logger;

import java.util.concurrent.TimeUnit;

public class Menu implements Runnable{


    @Override public void run() {

        while(true){

            prin

            try {
                wait();
            } catch (InterruptedException e) {
                Logger.error(e.getMessage());
            }
        }

    }

    public MenuCmds exit() {
        return MenuCmds.EXIT;
    }
}
