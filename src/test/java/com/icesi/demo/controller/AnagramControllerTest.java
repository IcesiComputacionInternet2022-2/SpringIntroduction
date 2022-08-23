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

    private AnagramListController anagramControlller;
    private AnagramListService anagramListService;

    @BeforeEach
    public void init(){
        anagramListService = mock(AnagramListService.class);
        anagramControlller = new AnagramListController(anagramListService);
    }

    @Test
    public void testController(){
        List<String> words = new ArrayList<>();
        words.add("Listen");
        words.add("Silent");

        when(anagramListService.isAnagram(any())).thenReturn(new AnagramResponseDTO(true));
        assertTrue(anagramControlller.isAnagram(words).isAnagram());
       // verify(anagramListService, times(0)).isAnagram(any());

    }

    @Test
    public void testAnagramWordsLengthIsDifferent(){
        List<String> words = new ArrayList<>();
        words.add("a");
        words.add("bb");

        when(anagramListService.isAnagram(any())).thenReturn(new AnagramResponseDTO(true));
        assertFalse(anagramControlller.isAnagram(words).isAnagram());
       // verify(anagramListService, times(1)).isAnagram(any());

    }

    @Test
    public void testNull(){
        List<String> words = new ArrayList<>();
        words.add("a");
        words.add(null);

        when(anagramListService.isAnagram(any())).thenReturn(new AnagramResponseDTO(true));
        assertFalse(anagramControlller.isAnagram(words).isAnagram());
        // verify(anagramListService, times(1)).isAnagram(any());

    }
}

