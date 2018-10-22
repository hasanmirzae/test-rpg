package com.example;

import com.example.pages.FrontPage;
import com.example.pages.Page;
import com.example.services.PageManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AppGuiTest {

    @Mock
    PageManager pageManager;

    @Mock
    Page somePage;




    String sampleKey = "SAMPLE_KEY";
    String pageName = "PAGE_NAME";

    @Before
    public void setup(){
        when(somePage.name()).thenReturn(pageName);
        when(pageManager.has(sampleKey)).thenReturn(true);
    }

    @Test
    public void should_open_right_page(){
        //given
        AppGui appGui = new AppGui(pageManager);
        when(pageManager.getPage(sampleKey)).thenReturn(somePage);
        //when
        appGui.openPage(sampleKey);
        //then
        assertTrue(appGui.getCurrentPage().name().equals(pageName));

    }

    @Test
    public void should_open_front_page_by_default(){
        //given
        AppGui appGui = new AppGui(pageManager);
        //when
        // by default
        //then
        assertNotNull(appGui.getCurrentPage());
        assertTrue(appGui.getCurrentPage() instanceof FrontPage);

    }

}
