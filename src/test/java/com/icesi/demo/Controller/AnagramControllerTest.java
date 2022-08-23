package com.icesi.demo.controller;

import com.icesi.demo.dto.ConfirmationDTO;
import com.icesi.demo.service.AnagramService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

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
        when(anagramService.checkAnagrams(any())).thenReturn(new ConfirmationDTO(true));

        assertTrue(anagramController.checkAnagrams(words).isAnagram());
    }

    @Test
    public void testControllerSizeIsMoreThanTwo(){
        List<String> words = new ArrayList<>();
        words.add("listen");
        words.add("silent");
        words.add("nfifafww");
        //when(anagramService.checkAnagrams(any())).thenReturn(new ConfirmationDTO(true));
        assertFalse(anagramController.checkAnagrams(words).isAnagram());
        verify(anagramService, times(0)).checkAnagrams(any());
    }

    @Test
    public void testControllerSizeLesserThanTwo(){
        List<String> words = new ArrayList<>();
        words.add("listen");
        assertFalse(anagramController.checkAnagrams(words).isAnagram());
        verify(anagramService, times(0)).checkAnagrams(any());
    }

    @Test
    public void testControllerNumbersNotAllowed(){
        List<String> words = new ArrayList<>();
        words.add("listen2");
        words.add("silent23523");
        assertFalse(anagramController.checkAnagrams(words).isAnagram());
        verify(anagramService, times(0)).checkAnagrams(any());
    }

    @Test
    public void testControllerNullsNotAllowed() {
        List<String> words = new ArrayList<>();
        words.add("listenToMePlease");
        words.add(null);

        assertFalse(anagramController.checkAnagrams(words).isAnagram());
        verify(anagramService, times(0)).checkAnagrams(any());
    }

    @Test
    public void testControllerNullAsAWord() {
        List<String> words = new ArrayList<>();
        words.add("null");
        words.add("llun");
        when(anagramService.checkAnagrams(any())).thenReturn(new ConfirmationDTO(true));
        assertTrue(anagramController.checkAnagrams(words).isAnagram());
    }

}
