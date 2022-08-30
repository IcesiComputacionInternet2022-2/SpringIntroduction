package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.implementation.AnagramServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
        String str1 ="listen";
        String str2 = "silent";

        AnagramResponseDTO isAnagram = anagramService.anagramString(str1,str2);

        assertTrue(isAnagram.getIsAnagram());
    }

    @Test
    public void testCaseInsensitive(){
        String str1 ="Listen";
        String str2 = "Silent";

        AnagramResponseDTO isAnagram = anagramService.anagramString(str1,str2);

        assertTrue(isAnagram.getIsAnagram());
    }

    @Test
    public void testAnagramWordsLengthIsDiff(){
        String str1 ="a";
        String str2 = "ab";

        AnagramResponseDTO isAnagram = anagramService.anagramString(str1,str2);

        assertFalse(isAnagram.getIsAnagram());
    }

    @Test
    public void testIsNotAnagram(){
        String str1 ="saient";
        String str2 = "silent";

        AnagramResponseDTO isAnagram = anagramService.anagramString(str1,str2);

        assertFalse(isAnagram.getIsAnagram());
    }

    @Test
    public void testRepeatedLetters(){
        String str1 ="listeen";
        String str2 = "sillent";

        AnagramResponseDTO isAnagram = anagramService.anagramString(str1,str2);

        assertFalse(isAnagram.getIsAnagram());
    }
}
