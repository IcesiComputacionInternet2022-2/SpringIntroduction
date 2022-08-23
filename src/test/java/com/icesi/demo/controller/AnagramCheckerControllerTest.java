package com.icesi.demo.controller;

import com.icesi.demo.dto.AnagramCheckerResponseDTO;
import com.icesi.demo.service.AnagramCheckerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AnagramCheckerControllerTest {

    private AnagramCheckerController anagramCheckerController;
    private AnagramCheckerService anagramCheckerService;

    @BeforeEach
    private void init() {
        anagramCheckerService = mock(AnagramCheckerService.class);
        anagramCheckerController = new AnagramCheckerController(anagramCheckerService);
    }

    @Test
    public void testController() {
        List<String> list = new ArrayList<>();
        list.add("silent");
        list.add("listen");
        when(anagramCheckerService.checkAnagram(any())).thenReturn(new AnagramCheckerResponseDTO(true));
        assertTrue(anagramCheckerController.checkAnagram(list).isResult());
    }

    @Test
    public void testControllerInputSizeLessThanTwo() {
        List<String> list = new ArrayList<>();
        list.add("hi");
        assertFalse(anagramCheckerController.checkAnagram(list).isResult());
        verify(anagramCheckerService, times(0)).checkAnagram(any());
    }

    @Test
    public void testControllerInputSizeGreaterThanTwo() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("bye");
        list.add("hi");
        assertFalse(anagramCheckerController.checkAnagram(list).isResult());
        verify(anagramCheckerService, times(0)).checkAnagram(any());
    }

    @Test
    public void testControllerInputNullContent() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add(null);
        assertFalse(anagramCheckerController.checkAnagram(list).isResult());
        verify(anagramCheckerService, times(0)).checkAnagram(any());
    }

    @Test
    public void testControllerInputNullList() {
        assertFalse(anagramCheckerController.checkAnagram(null).isResult());
        verify(anagramCheckerService, times(0)).checkAnagram(any());
    }

}
