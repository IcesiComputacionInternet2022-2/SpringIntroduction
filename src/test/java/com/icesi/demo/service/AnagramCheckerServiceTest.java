package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramCheckerResponseDTO;
import com.icesi.demo.service.implementation.AnagramCheckerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramCheckerServiceTest {

    private AnagramCheckerService anagramCheckerService;

    @BeforeEach
    private void init() {
        anagramCheckerService = new AnagramCheckerServiceImpl();
    }

    @Test
    public void testIsAnagram() {
        List<String> stringList = new ArrayList<>();
        stringList.add("listen");
        stringList.add("silent");
        AnagramCheckerResponseDTO res = anagramCheckerService.checkAnagram(stringList);
        assertTrue(res.isResult());
    }

    @Test
    public void testWordsLengthIsDifferent() {
        List<String> stringList = new ArrayList<>();
        stringList.add("ab");
        stringList.add("a");
        AnagramCheckerResponseDTO res = anagramCheckerService.checkAnagram(stringList);
        assertFalse(res.isResult());
    }

    @Test
    public void testAnagramCaseInsensitive() {
        List<String> stringList = new ArrayList<>();
        stringList.add("ListeN");
        stringList.add("SILent");
        AnagramCheckerResponseDTO res = anagramCheckerService.checkAnagram(stringList);
        assertTrue(res.isResult());
    }

    @Test
    public void testIsNotAnagram() {
        List<String> stringList = new ArrayList<>();
        stringList.add("string");
        stringList.add("strina");
        AnagramCheckerResponseDTO res = anagramCheckerService.checkAnagram(stringList);
        assertFalse(res.isResult());
    }

    @Test
    public void testRepeatedLetters() {
        List<String> stringList = new ArrayList<>();
        stringList.add("silent");
        stringList.add("llisten");
        AnagramCheckerResponseDTO res = anagramCheckerService.checkAnagram(stringList);
        assertFalse(res.isResult());
    }

    @Test
    public void testFirstWordIsLonger() {
        List<String> stringList = new ArrayList<>();
        stringList.add("llisten");
        stringList.add("silent");
        AnagramCheckerResponseDTO res = anagramCheckerService.checkAnagram(stringList);
        assertFalse(res.isResult());
    }

}
