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
    public void init() {
        anagramService = mock(AnagramService.class);
        anagramController = new AnagramController(anagramService);
    }

    @Test
    public void testController() {
        List<String> words = new ArrayList<>();
        words.add("listen");
        words.add("silent");
        when(anagramService.anagramResult(any())).thenReturn(new AnagramResponseDTO(true));
        assertTrue(anagramController.anagramResult(words).isResult());
    }

    @Test
    public void testControllerSizeIsMoreThanTwo() {
        List<String> words = new ArrayList<>();
        words.add("listen");
        words.add("silent");
        words.add("third");
        assertFalse(anagramController.anagramResult(words).isResult());
        verify(anagramService, times(0)).anagramResult(any());
    }

    @Test
    public void testControllerSizeIsLessThanTwo() {
        List<String> words = new ArrayList<>();
        words.add("listen");
        assertFalse(anagramController.anagramResult(words).isResult());
        verify(anagramService, times(0)).anagramResult(any());
    }
}
