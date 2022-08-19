package com.icesi.demo.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        AnagramResponseDTO result = anagramService.isAnagram("listen", "silent");
        assertTrue(result.isAnagram());
    }

    @Test
    public void testIsNotAnagram() {
        AnagramResponseDTO result = anagramService.isAnagram("String", "Strong");
        assertFalse(result.isAnagram());
    }

    @Test
    public void testAnagramWordsLengthIsDifferent() {
        AnagramResponseDTO result = anagramService.isAnagram("a", "ab");
        assertFalse(result.isAnagram());
    }

    @Test
    public void testAnagramCaseInsensitive() {
        AnagramResponseDTO result = anagramService.isAnagram("Silent", "Listen");
        assertTrue(result.isAnagram());
    }

    @Test
    public void testLengthWordOneIsLongerThanLengthWordTwo() {
        AnagramResponseDTO result = anagramService.isAnagram("Listening", "Silent");
        assertFalse(result.isAnagram());
    }
}
