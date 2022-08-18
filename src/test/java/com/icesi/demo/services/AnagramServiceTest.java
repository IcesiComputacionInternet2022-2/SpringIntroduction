package com.icesi.demo.services;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramListService;
import com.icesi.demo.service.implementation.AnagramListServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramServiceTest {

    private AnagramListService anagramListService;

    @BeforeEach
    private void init(){
        anagramListService = new AnagramListServiceImpl();
    }

    @Test
    public void testIsAnagram(){

        List<String> stringList = new ArrayList<String>();
        stringList.add("Listen");
        stringList.add("silent");

        AnagramResponseDTO result = anagramListService.isAnagram(stringList);

        assertTrue(result.isAnagram());

    }

    @Test
    public void testAnagramWordsLengthIsDifferent(){

        List<String> stringList = new ArrayList<String>();
        stringList.add("a");
        stringList.add("ab");

        AnagramResponseDTO result = anagramListService.isAnagram(stringList);

        assertFalse(result.isAnagram());

    }

    @Test
    public void testAnagramCaseSensitive(){

        List<String> stringList = new ArrayList<String>();
        stringList.add("NiCoLaS");
        stringList.add("solacin");

        AnagramResponseDTO result = anagramListService.isAnagram(stringList);

        assertTrue(result.isAnagram());

    }

    @Test
    public void testNotAnagram(){

        List<String> stringList = new ArrayList<String>();
        stringList.add("NiCPLaS");
        stringList.add("solacin");

        AnagramResponseDTO result = anagramListService.isAnagram(stringList);

        assertFalse(result.isAnagram());

    }

    @Test
    public void testAnagramRepeatedLetters(){

        List<String> stringList = new ArrayList<String>();
        stringList.add("aaa");
        stringList.add("aaa");

        AnagramResponseDTO result = anagramListService.isAnagram(stringList);

        assertTrue(result.isAnagram());

    }


    @Test
    public void testFirstWordIsLongerThanSecondOne(){

        List<String> stringList = new ArrayList<String>();
        stringList.add("amorn");
        stringList.add("roman");

        AnagramResponseDTO result = anagramListService.isAnagram(stringList);

        assertTrue(result.isAnagram());

    }
}
