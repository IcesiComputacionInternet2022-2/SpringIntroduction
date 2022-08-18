package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramResponseDTO;
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
    public void init(){
        anagramService = new AnagramServiceImpl();
    }

    @Test
    public void testIsAnagram(){
        List<String> stringList = new ArrayList<>();
        stringList.add("listen");
        stringList.add("silent");

        AnagramResponseDTO isAnagram = anagramService.isAnagram(stringList);

        assertTrue(isAnagram.isAnagram());
    }

    @Test
    public void testAnagramWordsLengthIsDifferent(){
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("ab");

        AnagramResponseDTO isAnagram = anagramService.isAnagram(stringList);

        assertFalse(isAnagram.isAnagram());
    }

    @Test
    public void testAnagramCaseInsensitive(){
        List<String> stringList = new ArrayList<>();
        stringList.add("Listen");
        stringList.add("Silent");

        AnagramResponseDTO isAnagram = anagramService.isAnagram(stringList);

        assertTrue(isAnagram.isAnagram());
    }

    @Test
    public void testNotAnagram(){
        List<String> stringList = new ArrayList<>();
        stringList.add("string");
        stringList.add("strong");

        AnagramResponseDTO isAnagram = anagramService.isAnagram(stringList);

        assertFalse(isAnagram.isAnagram());
    }

    @Test
    public void testAnagramRepeatedLetters(){
        List<String> stringList = new ArrayList<>();
        stringList.add("listent");
        stringList.add("sillent");

        AnagramResponseDTO isAnagram = anagramService.isAnagram(stringList);

        assertFalse(isAnagram.isAnagram());
    }

    @Test
    public void testWordOneIsLongerThanTheSecond(){
        List<String> stringList = new ArrayList<>();
        stringList.add("llisten");
        stringList.add("silent");

        AnagramResponseDTO isAnagram = anagramService.isAnagram(stringList);

        assertFalse(isAnagram.isAnagram());
    }
}
