package com.icesi.demo.controller;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AnagramControllerTest {

    private AnagramController anagramController;
    private AnagramService anagramService;

    @BeforeEach
    public void init(){
        anagramService = mock(AnagramService.class);
        anagramController = new AnagramController(anagramService);
    }//End init

    @Test
    public void testController(){
        List<String> words = new ArrayList<>();
        words.add("Listen");
        words.add("silent");
        when(anagramService.checkAnagram(any())).thenReturn(new AnagramResponseDTO(true));
        assertTrue(anagramController.checkAnagram(words).isResult());
    }//End testController

    @Test
    public void testControllerGreaterThanTwo(){
        List<String> words = new ArrayList<>();
        words.add("Listen");
        words.add("silent");
        words.add("third");
        assertFalse(anagramController.checkAnagram(words).isResult());
        verify(anagramService, times(0)).checkAnagram(any());
    }//End testControllerGreaterThanTwo

    @Test
    public void testControllerLessThanTwo(){
        List<String> words = new ArrayList<>();
        words.add("Listen");
        assertFalse(anagramController.checkAnagram(words).isResult());
        verify(anagramService, times(0)).checkAnagram(any());
    }//End testControllerLessThanTwo

}//End class
