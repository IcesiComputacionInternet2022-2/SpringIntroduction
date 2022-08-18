package com.icesi.demo.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.implementation.AnagramServiceImpl;

public class AnagramServiceTest {

    private AnagramService anagramService;

    @BeforeEach
    private void init() {
        anagramService = new AnagramServiceImpl();
    }

    @Test
    public void testIsAnagram() {
        List<String> strings = new ArrayList<>();
        strings.add("listen");
        strings.add("silent");
        AnagramResponseDTO result = anagramService.isAnagram(strings.get(0), strings.get(1));
        assertTrue(result.isAnagram());
    }

    @Test
    public void testIsNotAnagram() {
        List<String> strings = new ArrayList<>();
        strings.add("String");
        strings.add("Strong");
        AnagramResponseDTO result = anagramService.isAnagram(strings.get(0), strings.get(1));
        assertFalse(result.isAnagram());
    }

    @Test
    public void testAnagramWordsLengthIsDifferent() {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("ab");
        AnagramResponseDTO result = anagramService.isAnagram(strings.get(0), strings.get(1));
        assertFalse(result.isAnagram());
    }

    @Test
    public void testAnagramCaseInsensitive() {
        List<String> strings = new ArrayList<>();
        strings.add("Listen");
        strings.add("Silent");
        AnagramResponseDTO result = anagramService.isAnagram(strings.get(0), strings.get(1));
        assertTrue(result.isAnagram());
    }

    @Test
    public void testLengthWordOneIsLongerThanLengthWordTwo() {
        List<String> strings = new ArrayList<>();
        strings.add("Listening");
        strings.add("Silent");
        AnagramResponseDTO result = anagramService.isAnagram(strings.get(0), strings.get(1));
        assertFalse(result.isAnagram());
    }
}
