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

public class AnagramListControllerTest {

    private AnagramListController anagramListController;
    private AnagramListService anagramListService;

    @BeforeEach
    public void init() {
        anagramListService = mock(AnagramListService.class); //Para los métodos privados del controlador
        anagramListController = new AnagramListController(anagramListService);
    }


    @Test
    public void testControllerCorrect(){
        List<String> words = new ArrayList<>();
        words.add("silent");
        words.add("listen");

        when(anagramListService.isAnagram(any())).thenReturn(new AnagramResponseDTO(true));//

        assertTrue(anagramListController.isAnagram(words).isResult());

    }


    @Test
    public void testControllerSizeIsMoreThanTwo(){
        List<String> words = new ArrayList<>();
        words.add("listen");
        words.add("silent");
        words.add("silento");

        when(anagramListService.isAnagram(any())).thenReturn(new AnagramResponseDTO(false));//

        assertFalse(anagramListController.isAnagram(words).isResult());

    }

    @Test
    public void testControllerSizeIsLessThanTwo(){
        List<String> words = new ArrayList<>();
        words.add("listen");

        when(anagramListService.isAnagram(any())).thenReturn(new AnagramResponseDTO(false));//

        assertFalse(anagramListController.isAnagram(words).isResult());

    }


    @Test
    public void testControllerThereAreNull(){
        List<String> words = new ArrayList<>();
        words.add("listen");
        words.add(null);

        when(anagramListService.isAnagram(any())).thenReturn(new AnagramResponseDTO(false));//

        assertFalse(anagramListController.isAnagram(words).isResult());

    }

    @Test
    public void testControllerAreNumbers(){
        List<String> words = new ArrayList<>();
        words.add("123");
        words.add("321");

        when(anagramListService.isAnagram(any())).thenReturn(new AnagramResponseDTO(false));//

        assertFalse(anagramListController.isAnagram(words).isResult());

        verify(anagramListService,times(0)).isAnagram(any());

    }

    @Test
    public void testControllerListNull(){
        List<String> words = new ArrayList<>();

        when(anagramListService.isAnagram(any())).thenReturn(new AnagramResponseDTO(false));// 

        assertFalse(anagramListController.isAnagram(words).isResult());

    }


}
