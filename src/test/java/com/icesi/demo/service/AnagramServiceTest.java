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

    private AnagramService anagramService;

    @BeforeEach
    private void init () {
        anagramService = new AnagramListServiceImpl();
    }

    @Test
    public void testIfAnagram () {
        List<String> stringList = new ArrayList<>();
        String str1 = "listen";
        String str2 = "silent";

        AnagramResponseDTO result = anagramService.findAnagram(str1,str2);

        assertTrue(result.isResult());
    }


    @Test
    public void testLengthIsDifferent () {
        String str1 = "ab";
        String str2 = "a";

        AnagramResponseDTO result = anagramService.findAnagram(str1,str2);

        assertFalse(result.isResult());
    }

    @Test
    public void testIsCaseSensitive () {
        String str1 = "Listen";
        String str2 = "silent";

        AnagramResponseDTO result = anagramService.findAnagram(str1,str2);

        assertTrue(result.isResult());
    }

    @Test
    public void testNotAnagram () {
        String str1 = "String";
        String str2 = "Strong";

        AnagramResponseDTO result = anagramService.findAnagram(str1,str2);

        assertFalse(result.isResult());
    }

    @Test
    public void testRepeatedLetter() {
        String str1 = "listen";
        String str2 = "sillent";

        AnagramResponseDTO result = anagramService.findAnagram(str1,str2);

        assertFalse(result.isResult());
    }

    @Test
    public void testIsLonger () {
        String str1 = "llisten";
        String str2 = "silent";

        AnagramResponseDTO result = anagramService.findAnagram(str1,str2);

        assertFalse(result.isResult());
    }
}
