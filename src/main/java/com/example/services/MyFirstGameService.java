package com.example.services;

import com.example.utils.IOUtil;

import java.util.Random;

public class MyFirstGameService {

    int guess = new Random().nextInt(10);

    public void startNewGame(){
        System.out.print("Enter new username: ");
        String username = IOUtil.readString();
        System.out.println("Welcome "+username+" to MyFirstGame");
        playGame();
    }

    public void resume(){
        System.out.print("Enter username: ");
        String username = IOUtil.readString();
        System.out.println("Welcome back "+username+" to MyFirstGame");
        playGame();
    }

    public void playGame(){

        System.out.println("Let's guess a number now ...");
        int input = -1;
        int maxTries = 10;
        int tries;
        for(tries =0; tries<maxTries; tries++){
            System.out.print("Enter a number from 1 to 10: ");
            input = readGuess();
            if(input == guess){
                youWin();
                break;
            }else {
                if(!wantsToContinue()){
                    System.out.println("You gave up!");
                    break;
                }
            }
        }

    }

    private boolean wantsToContinue() {
        System.out.print("Do you want to continue? (Y/N): ");
        String answer = IOUtil.readString();
        return "Y".equals(new String(answer).toUpperCase());
    }

    private void youWin() {
        System.out.println("Congratulation! You won!!!");
    }

    private int readGuess() {
        try {
            String input = IOUtil.readString();
            return Integer.valueOf(input);
        }catch (Throwable e){
            System.out.println("Input is not a number");
            return -1;
        }
    }


}
