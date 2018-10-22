package com.example.controllers;

import com.example.services.AppGui;
import com.example.services.FrontPageService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class FrontPageControllerTest {


    @Mock
    AppGui appGui;

    @Mock
    FrontPageService frontPageService;

    @Before
    public void setup(){


    }

    @Test
    public void should_handle_cmd(){
        FrontPageController controller = new FrontPageController(appGui,frontPageService);
        //given
        Map<String, Runnable> handlers = mock(Map.class);
        when(handlers.get("1")).thenReturn(this::dummyAction);
        controller.setHandlers(handlers);
        controller.handleRequest("1");
    }

    private void dummyAction(){

    }
}
