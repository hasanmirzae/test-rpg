package com.example.models;

import java.io.Serializable;

public class GuessNumber implements Serializable {
    private int tries;

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }
}
