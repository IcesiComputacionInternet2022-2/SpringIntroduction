package com.icesi.demo.controller;

import static org.mockito.ArgumentMatchers.any;

import com.icesi.demo.dto.AnagramaDTO;
import com.icesi.demo.service.AnagramaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


public class AnagramaControllerTest {
    private List<String> list;
    private AnagramaController anagramaController;
    private AnagramaService anagramaService;

    @BeforeEach
    public void init(){
        list = new ArrayList<>();
        anagramaService = mock(AnagramaService.class);
        anagramaController = new AnagramaController(anagramaService);


    }

    @Test
    public void testController(){
        list.add("listen");
        list.add("silent");
        when(anagramaService.isAnagrama(any())).thenReturn(new AnagramaDTO(true));
        assertTrue(anagramaController.areAnagrama(list).isAnagrama());

    }

    @Test
    public void testControllerSizeMoreThanTwo(){
        list.add("hello");
        list.add("yallow");
        list.add("last");

        assertFalse(anagramaController.areAnagrama(list).isAnagrama());
        verify(anagramaService,times(0)).isAnagrama(any());

    }

    @Test
    public void testControllerSizeLessThanTwo(){
        list.add("aloh");

        assertFalse(anagramaController.areAnagrama(list).isAnagrama());
        verify(anagramaService,times(0)).isAnagrama(any());
    }

    @Test
    public void testControllerWithSpaces(){
        list.add("lis ten");
        list.add("silent");

        assertFalse(anagramaController.areAnagrama(list).isAnagrama());
        verify(anagramaService,times(0)).isAnagrama(any());
    }

    @Test
    public void testControllerWithNumbers(){
        list.add("l1st3n");
        list.add("s1l3nt");

        assertFalse(anagramaController.areAnagrama(list).isAnagrama());
        verify(anagramaService,times(0)).isAnagrama(any());
    }

    @Test
    public void testControllerSpecialChatacters(){
        list.add("hola#");
        list.add("*aloh");
        assertFalse(anagramaController.areAnagrama(list).isAnagrama());
        verify(anagramaService,times(0)).isAnagrama(any());
    }

    @Test
    public void testControllerNull(){
        list.add("hello");
        list.add(null);

        assertFalse(anagramaController.areAnagrama(list).isAnagrama());
        verify(anagramaService, times(0)).isAnagrama(any());
    }
}
