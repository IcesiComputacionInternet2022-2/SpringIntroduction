package com.icesi.demo.controller;

import com.icesi.demo.dto.IsAnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import com.icesi.demo.service.implementation.AnagramServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


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


        when(anagramService.isAnagram(ArgumentMatchers.any())).thenReturn(new IsAnagramResponseDTO(true));

        assertTrue(anagramController.isAnagram(words).isAnagram()); //Null pointer if when is not used because it returns null
        //Mocks are mocks (as mock-ups)
    }

    @Test
    public void testControllerListIsNull(){
        List<String> words = null;

        //when(anagramService.isAnagram(ArgumentMatchers.any())).thenReturn(new IsAnagramResponseDTO(true));

        assertFalse(anagramController.isAnagram(words).isAnagram()); //Null pointer if when is not used because it returns null
        //Mocks are mocks (as mock-ups)


    }
    //Verifications should be moved to the controller class
    @Test
    public void testControllerHasNullWords(){
        List<String> words = new ArrayList<>();
        words.add(null);
        words.add("silent");

        assertFalse(anagramController.isAnagram(words).isAnagram()); //Null pointer if when is not used because it returns null
        //Mocks are mocks (as mock-ups)


    }
    //Verifications should be moved to the controller class
    @Test
    public void testControllerZeroElements(){
        List<String> words = new ArrayList<>();

        assertFalse(anagramController.isAnagram(words).isAnagram());
    }

    @Test
    public void testControllerOneElement(){
        List<String> words = new ArrayList<>();

        words.add("Test");

        assertFalse(anagramController.isAnagram(words).isAnagram());
    }

    @Test
    public void testControllerTwoElements(){
        List<String> words = new ArrayList<>();

        words.add("silent");
        words.add("listen");

        when(anagramService.isAnagram(ArgumentMatchers.any())).thenReturn(new IsAnagramResponseDTO(true));


        assertTrue(anagramController.isAnagram(words).isAnagram());
    }

    @Test
    public void testControllerMoreThanTwoElements(){
        List<String> words = new ArrayList<>();

        words.add("silent");
        words.add("listen");
        words.add("netsil");

        when(anagramService.isAnagram(ArgumentMatchers.any())).thenReturn(new IsAnagramResponseDTO(true));


        assertTrue(anagramController.isAnagram(words).isAnagram());
    }

    @Test
    public void testControllerValidCharacters(){
        List<String> words = new ArrayList<>();

        words.add("T3st");
        words.add("T3st");

        assertFalse(anagramController.isAnagram(words).isAnagram());
    }

    @Test
    public void testControllerEmptyWords(){
        List<String> words = new ArrayList<>();

        words.add("");
        words.add("");

        assertFalse(anagramController.isAnagram(words).isAnagram());
    }

}
