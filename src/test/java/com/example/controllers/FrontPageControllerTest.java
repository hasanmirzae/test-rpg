package com.example.controllers;

import com.example.AppGui;
import com.example.controllers.FrontPageController;
import com.example.pages.GamesListPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FrontPageControllerTest {


    @Mock
    AppGui appGui;

    @Before
    public void setup(){


    }

    @Test
    public void should_handle_list_games_menu_item_correctly(){
        //given
        FrontPageController controller = new FrontPageController(appGui);
        //when
        controller.handleRequest(FrontPageController.CMD_LIST_GAME);
        //then
        verify(appGui,times(1)).openPage(GamesListPage.KEY);
    }


    @Test
    public void should_handle_exit_menu_item_correctly(){
        //given
        FrontPageController controller = new FrontPageController(appGui);
        //when
        controller.handleRequest(FrontPageController.CMD_EXIT);
        //then
        verify(appGui,times(1)).exit();
    }


    @Test
    public void should_not_try_open_page_on_wrong_menu_item(){
        //given
        FrontPageController controller = new FrontPageController(appGui);
        //when
        controller.handleRequest("some_wrong_menu_item");
        //then
        verify(appGui,times(0)).openPage(any());
    }

}
