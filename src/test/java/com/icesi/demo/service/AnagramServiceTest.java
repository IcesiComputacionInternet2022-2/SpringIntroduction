package com.icesi.demo.service;

import com.icesi.demo.dto.ConfirmationDTO;
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
    private void init(){
        anagramService= new AnagramServiceImpl();
    }

    @Test
    public void testIsAnagram(){
        List<String> stringList = new ArrayList<>();
        stringList.add("listen");
        stringList.add("silent");

        ConfirmationDTO result = anagramService.checkAnagrams(stringList);

        assertTrue(result.isAnagram());
    }

    @Test
    public void testAnagramWordsLengthIsDifferent(){
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("ab");

        ConfirmationDTO result = anagramService.checkAnagrams(stringList);

        assertFalse(result.isAnagram());
    }

    @Test
    public void testAnagramCaseInsensitive(){
        List<String> stringList = new ArrayList<>();
        stringList.add("Listen");
        stringList.add("Silent");

        ConfirmationDTO result = anagramService.checkAnagrams(stringList);

        assertTrue(result.isAnagram());
    }

    @Test
    public void testNotAnagram(){
        List<String> stringList = new ArrayList<>();
        stringList.add("String");
        stringList.add("Strong");

        ConfirmationDTO result = anagramService.checkAnagrams(stringList);

        assertFalse(result.isAnagram());
    }

    @Test
    public void testAnagramRepeatedLetters(){
        List<String> stringList = new ArrayList<>();
        stringList.add("listen");
        stringList.add("sillent");

        ConfirmationDTO result = anagramService.checkAnagrams(stringList);

        assertFalse(result.isAnagram());
    }

    @Test
    public void testWordOneIsLongerThanTheSecond(){
        List<String> stringList = new ArrayList<>();
        stringList.add("llisten");
        stringList.add("Silent");

        ConfirmationDTO result = anagramService.checkAnagrams(stringList);

        assertFalse(result.isAnagram());
    }


}
