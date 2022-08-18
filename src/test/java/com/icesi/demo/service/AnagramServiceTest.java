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
    private void init() {
        anagramService = new AnagramServiceImpl();
    }

    @Test
    public void testIsAnagram() {
        List<String> stringList = new ArrayList<>();
        stringList.add("listen");
        stringList.add("silent");

        AnagramResponseDTO responseDTO = anagramService.anagramResult(stringList);

        assertTrue(responseDTO.isResult());
    }

    @Test
    public void testIsAnagramWordsLengthIsDifferent() {
        List<String> stringList = new ArrayList<>();
        stringList.add("bed");
        stringList.add("pillow");

        AnagramResponseDTO responseDTO = anagramService.anagramResult(stringList);

        assertFalse(responseDTO.isResult());
    }

    @Test
    public void testIsAnagramCaseInsensitive() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Listen");
        stringList.add("Silent");

        AnagramResponseDTO responseDTO = anagramService.anagramResult(stringList);

        assertTrue(responseDTO.isResult());
    }

    @Test
    public void testNotAnagram() {
        List<String> stringList = new ArrayList<>();
        stringList.add("String");
        stringList.add("Strong");

        AnagramResponseDTO responseDTO = anagramService.anagramResult(stringList);

        assertFalse(responseDTO.isResult());
    }

    @Test
    public void testAnagramRepeatedLetters() {
        List<String> stringList = new ArrayList<>();
        stringList.add("listen");
        stringList.add("sillent");

        AnagramResponseDTO responseDTO = anagramService.anagramResult(stringList);

        assertFalse(responseDTO.isResult());
    }

    @Test
    public void testWordOneIsLongerThanTheSecond() {
        List<String> stringList = new ArrayList<>();
        stringList.add("llisten");
        stringList.add("silent");

        AnagramResponseDTO responseDTO = anagramService.anagramResult(stringList);

        assertFalse(responseDTO.isResult());
    }
}
