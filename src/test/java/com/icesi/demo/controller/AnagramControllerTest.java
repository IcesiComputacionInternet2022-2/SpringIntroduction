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
    }

    @Test
    public void testController(){

        List<String> words = new ArrayList<>();
        words.add("listen");
        words.add("silent");

        when(anagramService.isAnagram(any())).thenReturn(new AnagramResponseDTO(true));
        assertTrue(anagramController.isAnagram(words).isAnagram());
    }

    @Test
    public void testControllerSizeMoreThanTwo(){

        List<String> words = new ArrayList<>();
        words.add("listen");
        words.add("silent");
        words.add("third");

        //when(anagramService.isAnagram(any())).thenReturn(new AnagramResponseDTO(true));
        assertFalse(anagramController.isAnagram(words).isAnagram());
        verify(anagramService, times(0)).isAnagram(any());
    }

    @Test
    public void testControllerSizeLessThanTwo(){

        List<String> words = new ArrayList<>();
        words.add("listen");

        //when(anagramService.isAnagram(any())).thenReturn(new AnagramResponseDTO(true));
        assertFalse(anagramController.isAnagram(words).isAnagram());
        verify(anagramService, times(0)).isAnagram(any());
    }

    @Test
    public void testControllerContainsNull(){

        List<String> words = new ArrayList<>();
        words.add("listen");
        words.add(null);

        //when(anagramService.isAnagram(any())).thenReturn(new AnagramResponseDTO(true));
        assertFalse(anagramController.isAnagram(words).isAnagram());
        verify(anagramService, times(0)).isAnagram(any());
    }

    @Test
    public void testControllerContainsNumber(){

        List<String> words = new ArrayList<>();
        words.add("listen");
        words.add("silent1");

        //when(anagramService.isAnagram(any())).thenReturn(new AnagramResponseDTO(true));
        assertFalse(anagramController.isAnagram(words).isAnagram());
        verify(anagramService, times(0)).isAnagram(any());
    }
}
