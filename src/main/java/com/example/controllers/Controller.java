package com.example.controllers;

import com.example.pages.Page;

public interface Controller {

    void handleRequest(Page page, char key);
}
