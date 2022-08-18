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
    private void init(){
        anagramService = new AnagramServiceImpl();
    }
    @Test
    public void testIsAnagram(){
        List<String> stringList = new ArrayList<>();
        stringList.add("listen");
        stringList.add("silent");
        AnagramResponseDTO result = anagramService.checkAnagram(stringList);
        assertTrue(result.isResult());
    }//End testIsAnagram

    @Test
    public void testAnagramWordsLengthIsDifferent(){
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("ab");
        AnagramResponseDTO result = anagramService.checkAnagram(stringList);
        assertFalse(result.isResult());
    }//End testAnagramWordsLengthIsDifferent

    @Test
    public void testAnagramCaseInsensitive(){
        List<String> stringList = new ArrayList<>();
        stringList.add("Listen");
        stringList.add("Silent");
        AnagramResponseDTO result = anagramService.checkAnagram(stringList);
        assertTrue(result.isResult());
    }//End testAnagramWordsLengthIsDifferent

    @Test
    public void testIsNotAnagram(){
        List<String> stringList = new ArrayList<>();
        stringList.add("string");
        stringList.add("strina");
        AnagramResponseDTO result = anagramService.checkAnagram(stringList);
        assertFalse(result.isResult());
    }//End testIsAnagram

    @Test
    public void testAnagramRepeatedLetters(){
        List<String> stringList = new ArrayList<>();
        stringList.add("listen");
        stringList.add("sillent");
        AnagramResponseDTO result = anagramService.checkAnagram(stringList);
        assertFalse(result.isResult());
    }//End testIsAnagram

    @Test
    public void testWordOneIsLongerThanTheSecond(){
        List<String> stringList = new ArrayList<>();
        stringList.add("llisten");
        stringList.add("silent");
        AnagramResponseDTO result = anagramService.checkAnagram(stringList);
        assertFalse(result.isResult());
    }//End testIsAnagram
}//End AnagramServiceTest
