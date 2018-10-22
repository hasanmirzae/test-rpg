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
        username = IOUtil.prompt("Enter new username");
        System.out.println("Welcome "+username+" to \"Guess Number Game\"");
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
        username = IOUtil.prompt("Enter username");
        System.out.println("Welcome back "+username+" to GuessNumberGamePage");
        load();
    }

    public void playGame(){

        System.out.println("Let's guess a number now ...");
        while(tries <= maxTries){
            System.out.print(String.format("[%d / %d] Enter a natural number from 1 to %d: ",tries,maxTries,maxTries));
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
        if (tries >= maxTries){
            gameOver();
        }
    }

    private void gameOver() {
        System.out.println("Game over! You lost!");
    }

    private boolean wantsToContinue() {
        String answer = IOUtil.prompt("Do you want to continue? (Y/N)");
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
            System.out.println("Input is not a number!");
            return -1;
        }
    }

    @Override public String uuid() {
        return "guess-number-game";
    }

}
