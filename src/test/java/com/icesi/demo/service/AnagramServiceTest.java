package com.icesi.demo.service;

import com.icesi.demo.dto.IsAnagramResponseDTO;
import com.icesi.demo.service.implementation.AnagramServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramServiceTest{
    private AnagramService anagramService;


    @BeforeEach
    public void init() {
        anagramService = new AnagramServiceImpl();
    }

    @Test
    public void testIsAnagram() {
        List<String> stringList = new ArrayList<>();
        stringList.add("listen");
        stringList.add("silent");

        IsAnagramResponseDTO result = anagramService.isAnagram(stringList);

        assertTrue(result.isAnagram());
    }

    @Test
    public void testIsAnagramCaseInsensitive() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Listen");
        stringList.add("Silent");

        IsAnagramResponseDTO result = anagramService.isAnagram(stringList);

        assertTrue(result.isAnagram());
    }

    @Test
    public void testIsAnagramWordLengthDifferent() {
        List<String> stringList = new ArrayList<>();
        stringList.add("aa");
        stringList.add("a");

        IsAnagramResponseDTO result = anagramService.isAnagram(stringList);

        assertFalse(result.isAnagram());
    }

    @Test
    public void testIsAnagramFalse() {
        List<String> stringList = new ArrayList<>();
        stringList.add("steam");
        stringList.add("silent");

        IsAnagramResponseDTO result = anagramService.isAnagram(stringList);

        assertFalse(result.isAnagram());
    }

    @Test
    public void testIsAnagramLengthDifferentRevers() {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("aa");

        IsAnagramResponseDTO result = anagramService.isAnagram(stringList);

        assertFalse(result.isAnagram());
    }

    @Test
    public void testIsAnagramRepeatedLetter() {
        List<String> stringList = new ArrayList<>();
        stringList.add("casitaa");
        stringList.add("caatasi");

        IsAnagramResponseDTO result = anagramService.isAnagram(stringList);

        assertTrue(result.isAnagram());
    }
}
