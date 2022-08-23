package com.icesi.demo.controller;

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
    public void init() {
        anagramService = mock(AnagramService.class);
        anagramController = new AnagramController(anagramService);
    }

    @Test
    public void testController() {
        List<String> words = new ArrayList<>();
        words.add("listen");
        words.add("silent");
        when(anagramService.isAnagram(any())).thenReturn(true);

        assertTrue(anagramController.checkAnagram(words));
    }

    @Test
    public void testControllerLength() {
        List<String> words = new ArrayList<>();
        words.add("listen");
        words.add("silent");
        words.add("third");

        assertFalse(anagramController.checkAnagram(words));
        verify(anagramService, times(0)).isAnagram(any());
    }

    @Test
    public void testControllerLessThenTwo() {
        List<String> words = new ArrayList<>();
        words.add("listen");

        assertFalse(anagramController.checkAnagram(words));
        verify(anagramService, times(0)).isAnagram(any());
    }

    @Test
    public void testControllerNoNumbers() {
        List<String> words = new ArrayList<>();
        words.add("listen04");
        words.add("listen40");

        assertFalse(anagramController.checkAnagram(words));
        verify(anagramService, times(0)).isAnagram(any());
    }

    @Test
    public void testControllerNoNulls() {
        List<String> words = new ArrayList<>();
        words.add("listen04");
        words.add(null);

        assertFalse(anagramController.checkAnagram(words));
        verify(anagramService, times(0)).isAnagram(any());
    }

    @Test
    public void testControllerNoFalseNull() {
        List<String> words = new ArrayList<>();
        words.add("null");
        words.add("luln");
        when(anagramService.isAnagram(any())).thenReturn(true);
        assertTrue(anagramController.checkAnagram(words));
    }
}
