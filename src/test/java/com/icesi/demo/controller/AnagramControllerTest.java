package com.icesi.demo.controller;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AnagramControllerTest {

    private AnagramListController anagramListController;
    private AnagramListService anagramListService;

    @BeforeEach
    public void init(){
        anagramListService = mock(AnagramListService.class);
        anagramListController = new AnagramListController(anagramListService);
    }

    @Test
    public void testController(){
        List<String> words = new ArrayList<>();
        words.add("listen");
        words.add("silent");

        when(anagramListService.isListAnagram(any())).thenReturn(new AnagramResponseDTO(true));

        assertTrue(anagramListController.isAnagram(words).getResult());
    }

    @Test
    public void testControllerNullList(){
        List<String> words = null;

        assertFalse(anagramListController.isAnagram(words).getResult());
        verify(anagramListService, times(0)).isListAnagram(any());
    }

    @Test
    public void testControllerContainsNull(){
        List<String> words = new ArrayList<>();
        words.add("listen");
        words.add(null);
        words.add("silent");

        assertFalse(anagramListController.isAnagram(words).getResult());
        verify(anagramListService, times(0)).isListAnagram(any());
    }

    @Test
    public void testControllerOneorLess(){
        List<String> words = new ArrayList<>();
        words.add("listen");

        assertFalse(anagramListController.isAnagram(words).getResult());
        verify(anagramListService, times(0)).isListAnagram(any());
    }





}
