package com.icesi.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

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
        when(anagramService.isAnagram(any(), any())).thenReturn(new AnagramResponseDTO(true));
        assertTrue(anagramController.isAnagram(words).isAnagram());
    }

    @Test
    public void testControllerSizeIsMoreThanTwo() {
        List<String> words = new ArrayList<>();
        words.add("listen");
        words.add("silent");
        words.add("third");
        //when(anagramService.isAnagram(any(), any())).thenReturn(new AnagramResponseDTO(true));
        assertFalse(anagramController.isAnagram(words).isAnagram());
        verify(anagramService, times(0)).isAnagram(any(), any());
    }

    @Test
    public void testControllerSizeIsLessThanTwo() {
        List<String> words = new ArrayList<>();
        words.add("listen");
        //when(anagramService.isAnagram(any(), any())).thenReturn(new AnagramResponseDTO(true));
        assertFalse(anagramController.isAnagram(words).isAnagram());
        verify(anagramService, times(0)).isAnagram(any(), any());
    }

    @Test
    public void testControllerElementNotNull() {
        List<String> words = new ArrayList<>();
        words.add("listen");
        words.add(null);
        //when(anagramService.isAnagram(any(), any())).thenReturn(new AnagramResponseDTO(true));
        assertFalse(anagramController.isAnagram(words).isAnagram());
        verify(anagramService, times(0)).isAnagram(any(), any());
    }

    @Test
    public void testControllerElementMatches() {
        List<String> words = new ArrayList<>();
        words.add("list1n");
        words.add("s1lent");
        //when(anagramService.isAnagram(any(), any())).thenReturn(new AnagramResponseDTO(true));
        assertFalse(anagramController.isAnagram(words).isAnagram());
        verify(anagramService, times(0)).isAnagram(any(), any());
    }
}
