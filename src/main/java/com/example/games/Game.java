package com.example.games;

public interface Game<T>{

    void startNewGame();

    void save(T snapshot);

    T load();
}
