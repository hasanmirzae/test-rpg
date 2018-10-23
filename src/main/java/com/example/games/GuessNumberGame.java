package com.example.games;

import com.example.models.GuessNumber;
import com.example.utils.IOUtil;

import java.io.FileNotFoundException;
import java.util.Random;

/*
 * A simple game that expects user to guess a number which randomly was generated.
 */
public class GuessNumberGame implements Game{

    private int guess = new Random().nextInt(10);
    private int input = -1;
    private int maxTries = 10;
    private int tries = 1;
    private String username;

    public void startNewGame(){
        initGame();
        username = IOUtil.prompt("What is your name?");
        System.out.println("\nWelcome "+username+" to \"Guess Number Game\"");
        System.out.println("\nYou need to guess the magical number to win.\n"
                + "You have "+maxTries+" tries to find that number, otherwise you will die!\n");
        playGame();
    }

    private void initGame() {
        input = 0;
        tries = 1;
        username = null;
        guess = new Random().nextInt(10);
    }

    @Override public void save() {
        GuessNumber snapshot = new GuessNumber(tries,guess);
        if (!IOUtil.writeObjectToFile(getFilename(),snapshot)){
            System.out.println("Something went wrong when saving your game :(");
        }else {
            System.out.println("\nYour game saved successfully for \""+username+"\"");
        }
    }

    private String getFilename() {
        return username+"-"+uuid()+".rpg";
    }

    @Override public void load() {
        try{
            GuessNumber snapshot = (GuessNumber) IOUtil.loadObjectFromFile(getFilename());
            tries = snapshot.getTries();
            guess = snapshot.getAnswer();
            System.out.println("\nYour game loaded successfully for \""+username+"\"");
            playGame();
        }catch (Throwable e){
            if (e.getCause() instanceof FileNotFoundException){
                System.out.println("\nNo game found for "+username);
            }else {
                System.out.println("\nFailed to load the game for "+username);
            }
        }
    }



    public void resume(){
        username = IOUtil.prompt("Enter username");
        System.out.println("\nWelcome back "+username+" to GuessNumberGamePage");
        load();
    }

    public void playGame(){

        System.out.println("\nLet's guess a number now ...");
        while(tries <= maxTries){
            System.out.print(String.format("[%d / %d] Enter a natural number from 1 to %d: ",tries,maxTries,maxTries));
            input = readGuess();
            tries++;
            if(input == guess){
                youWin();
                break;
            }else {
                if(!wantsToContinue()){
                    System.out.println("\nYou gave up! :(");
                    break;
                }
            }
        }
        if (tries >= maxTries){
            gameOver();
        }
    }

    private void gameOver() {
        System.out.println("\nGame over! You lost! :(");
    }

    private boolean wantsToContinue() {
        String answer = IOUtil.prompt("Do you want to continue? (Y/N)");
        return "Y".equals(new String(answer).toUpperCase());
    }

    private void youWin() {
        System.out.println("\nCongratulation! You won!!!");
    }

    private int readGuess() {
        try {
            String input = IOUtil.readString();
            return Integer.valueOf(input);
        }catch (NumberFormatException e){
            System.out.println("\nInput is not a number!");
            return -1;
        }
    }

    @Override public String uuid() {
        return "guess-number-game";
    }

}
