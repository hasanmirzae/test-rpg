package com.example.controllers;

import com.example.AppGui;
import com.example.controllers.GuessNumberGameController;
import com.example.games.GuessNumberGame;
import com.example.pages.GuessNumberGamePage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GuessNumberGameControllerTest {


    @Mock
    AppGui appGui;

    @Mock
    GuessNumberGame guessNumberGame;


    @Before
    public void setup(){

    }

    @Test
    public void should_handle_start_new_game_menu_item_correctly(){
        //given
        GuessNumberGameController controller = new GuessNumberGameController(appGui,guessNumberGame);
        //when
        controller.handleRequest(GuessNumberGameController.CMD_START_NEW);
        //then
        verify(guessNumberGame,times(1)).startNewGame();
    }


    @Test
    public void should_handle_resume_menu_item_correctly(){
        //given
        GuessNumberGameController controller = new GuessNumberGameController(appGui,guessNumberGame);
        //when
        controller.handleRequest(GuessNumberGameController.CMD_RESUME);
        //then
        verify(guessNumberGame,times(1)).resume();
    }


    @Test
    public void should_handle_save_menu_item_correctly(){
        //given
        GuessNumberGameController controller = new GuessNumberGameController(appGui,guessNumberGame);
        //when
        controller.handleRequest(GuessNumberGameController.CMD_SAVE);
        //then
        verify(guessNumberGame,times(1)).save();
    }


    @Test
    public void should_handle_exit_menu_item_correctly(){
        //given
        GuessNumberGameController controller = new GuessNumberGameController(appGui,guessNumberGame);
        //when
        controller.handleRequest(GuessNumberGameController.CMD_EXIT);
        //then
        verify(appGui,times(1)).goHome();
    }


    @Test
    public void should_not_try_call_anything_on_wrong_menu_item(){
        //given
        GuessNumberGameController controller = new GuessNumberGameController(appGui,guessNumberGame);
        //when
        controller.handleRequest("some_wrong_menu_item");
        //then
        verify(appGui,times(0)).openPage(any());
        verify(appGui,times(0)).exit();
        verify(guessNumberGame,times(0)).save();
        verify(guessNumberGame,times(0)).resume();
        verify(guessNumberGame,times(0)).startNewGame();
    }

}
