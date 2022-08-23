package com.icesi.demo.controller;

import com.icesi.demo.service.AnagramService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        when(anagramService.isAnagram(any())).thenReturn(Boolean.TRUE);

        assertTrue(anagramController.checkAnagram(words));
    }
}
