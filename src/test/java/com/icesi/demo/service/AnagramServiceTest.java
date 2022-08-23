package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramDTO;
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
        stringList.add("banjo");
        stringList.add("jabon");

        AnagramDTO result = anagramService.anagramTwoWords(stringList);

        assertTrue(result.isResult());
    }

    @Test
    public void testAnagramWordsLengthIsDifferent(){
        List<String> stringList = new ArrayList<>();
        stringList.add("banjo");
        stringList.add("jabons");

        AnagramDTO result = anagramService.anagramTwoWords(stringList);

        assertFalse(result.isResult());
    }

    @Test
    public void testAnagramCase(){
        List<String> stringList = new ArrayList<>();
        stringList.add("BanJo");
        stringList.add("jaBOn");

        AnagramDTO result = anagramService.anagramTwoWords(stringList);

        assertTrue(result.isResult());
    }

    @Test
    public void testIsNotAnagram(){
        List<String> stringList = new ArrayList<>();
        stringList.add("banca");
        stringList.add("janso");

        AnagramDTO result = anagramService.anagramTwoWords(stringList);

        assertFalse(result.isResult());
    }

    @Test
    public void testAnagramRepeatedLetters(){
        List<String> stringList = new ArrayList<>();
        stringList.add("carro");
        stringList.add("rraco");

        AnagramDTO result = anagramService.anagramTwoWords(stringList);

        assertTrue(result.isResult());
    }

    @Test
    public void testAnagramWordsLengthIsDifferentReverse(){
        List<String> stringList = new ArrayList<>();
        stringList.add("banjos");
        stringList.add("jabon");

        AnagramDTO result = anagramService.anagramTwoWords(stringList);

        assertFalse(result.isResult());
    }
}
