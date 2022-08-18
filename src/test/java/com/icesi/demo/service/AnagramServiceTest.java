package com.icesi.demo.service;

import com.icesi.demo.service.implementation.AnagramServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramServiceTest {

    private AnagramService anagramService;

    @BeforeEach
    private void init() {
        anagramService = new AnagramServiceImpl();
    }

    @Test
    public void testIsAnagram() {
        List<String> stringList = new ArrayList<>();
        stringList.add("listen");
        stringList.add("silent");
        
        boolean result =  anagramService.isAnagram(stringList);

        assertTrue(result);
    }

    @Test
    public void testIsNotAnagram() {
        List<String> stringList = new ArrayList<>();
        stringList.add("String");
        stringList.add("Strong");

        boolean result =  anagramService.isAnagram(stringList);

        assertFalse(result);
    }

    @Test
    public void testCaseInsensitive() {
        List<String> stringList = new ArrayList<>();
        stringList.add("LisTen");
        stringList.add("SIlENt");

        boolean result =  anagramService.isAnagram(stringList);

        assertTrue(result);
    }

    @Test
    public void testAnagramWordsLenDifferent() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Listen");
        stringList.add("Esternocleidomastoideo");

        boolean result =  anagramService.isAnagram(stringList);

        assertFalse(result);
    }

    @Test
    public void testAnagramRepeatedLetters() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Listen");
        stringList.add("Sillent");

        boolean result =  anagramService.isAnagram(stringList);

        assertFalse(result);
    }
}
