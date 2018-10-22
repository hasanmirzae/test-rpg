package com.example.controllers;

import com.example.AppGui;
import com.example.controllers.GamesListController;
import com.example.pages.GamesListPage;
import com.example.pages.GuessNumberGamePage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GamesListControllerTest {


    @Mock
    AppGui appGui;


    @Before
    public void setup(){


    }

    @Test
    public void should_handle_menu_item_correctly(){
        //given
        GamesListController controller = new GamesListController(appGui);
        //when
        controller.handleRequest(GamesListController.CMD_GUESS_NUMBER_GAME);
        //then
        verify(appGui,times(1)).openPage(GuessNumberGamePage.KEY);
    }


    @Test
    public void should_handle_exit_menu_item_correctly(){
        //given
        GamesListController controller = new GamesListController(appGui);
        //when
        controller.handleRequest(GamesListController.CMD_EXIT);
        //then
        verify(appGui,times(1)).goHome();
    }


    @Test
    public void should_not_try_open_page_or_exit_on_wrong_menu_item(){
        //given
        GamesListController controller = new GamesListController(appGui);
        //when
        controller.handleRequest("some_wrong_menu_item");
        //then
        verify(appGui,times(0)).openPage(any());
        verify(appGui,times(0)).exit();
    }

}
