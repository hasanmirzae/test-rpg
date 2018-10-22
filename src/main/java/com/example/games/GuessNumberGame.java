package com.example.games;

import com.example.models.GuessNumber;
import com.example.utils.IOUtil;
import com.example.utils.Logger;

import java.io.FileNotFoundException;
import java.util.Random;

public class GuessNumberGame implements Game{

    private int guess = new Random().nextInt(10);
    private int input = -1;
    private int maxTries = 10;
    private int tries = 1;
    private String username;

    public void startNewGame(){
        System.out.print("Enter new username: ");
        username = IOUtil.readString();
        System.out.println("Welcome "+username+" to GuessNumberGamePage");
        playGame();
    }

    @Override public void save() {
        GuessNumber snapshot = new GuessNumber(tries,guess);
        if (!IOUtil.writeObjectToFile(username+".rpg",snapshot)){
            System.out.println("Something went wrong when saving your game :(");
        }
    }

    @Override public void load() {
        try{
            GuessNumber snapshot = (GuessNumber) IOUtil.loadObjectFromFile(username+".rpg");
            tries = snapshot.getTries();
            guess = snapshot.getAnswer();
            System.out.println("Game loaded successfully for "+username);
            playGame();
        }catch (Throwable e){
            if (e.getCause() instanceof FileNotFoundException){
                System.out.println("No game found for "+username);
            }else {
                System.out.println("Failed to load the game for "+username);
            }
        }
    }


    public void resume(){
        System.out.print("Enter username: ");
        username = IOUtil.readString();
        System.out.println("Welcome back "+username+" to GuessNumberGamePage");
        load();
    }

    public void playGame(){

        System.out.println("Let's guess a number now ...");
        while(tries <= maxTries){
            System.out.print(String.format("[%d / %d] Enter a number from 1 to 10: ",tries,maxTries));
            input = readGuess();
            tries++;
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
