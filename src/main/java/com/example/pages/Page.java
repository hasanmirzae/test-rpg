package com.example.pages;

public interface Page {

    void showMenu();
    void onKeyPress(char cmd);
    PageIDs getPageId();
}
