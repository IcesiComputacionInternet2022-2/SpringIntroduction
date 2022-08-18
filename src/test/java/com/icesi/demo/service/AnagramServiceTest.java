package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.implementation.AnagramListServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramServiceTest {

    private AnagramListService anagramListService;

    @BeforeEach
    public void init(){
        anagramListService = new AnagramListServiceImpl();
    }


    @Test
    public void testIsListAnagram(){
        List<String> stringList = new ArrayList<>();
        stringList.add("listen");
        stringList.add("silent");
        stringList.add("tensil");
        stringList.add("slient");

        AnagramResponseDTO result = anagramListService.isListAnagram(stringList);

        assertTrue(result.getResult());
    }

    @Test
    public void testAnagramWordsLengthIsDifferent(){
        List<String> stringList = new ArrayList<>();
        stringList.add("ba");
        stringList.add("ab");
        stringList.add("abc");

        AnagramResponseDTO result = anagramListService.isListAnagram(stringList);

        assertFalse(result.getResult());
    }

    @Test
    public void testNotAnagram(){
        List<String> stringList = new ArrayList<>();
        stringList.add("sky");
        stringList.add("ice");

        AnagramResponseDTO result = anagramListService.isListAnagram(stringList);

        assertFalse(result.getResult());
    }



}
