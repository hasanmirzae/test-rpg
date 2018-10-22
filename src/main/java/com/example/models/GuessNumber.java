package com.example.models;

import java.io.Serializable;

/*
 * Model to store and load the game status.
 */
public class GuessNumber implements Serializable {
    private int tries;
    private int answer;

    public GuessNumber(int tries, int answer) {
        this.tries = tries;
        this.answer = answer;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }
}
