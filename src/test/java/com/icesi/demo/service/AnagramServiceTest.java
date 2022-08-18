package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramaDTO;
import com.icesi.demo.service.implementation.AnagramaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramServiceTest {

    private AnagramaService anagramaService;
    private List<String> words;

    @BeforeEach
    private void init(){
        anagramaService = new AnagramaServiceImpl();
        words = new ArrayList<>();
    }

    @Test
    public void testIsAnagrama(){

        words.add("listen");
        words.add("silent");

        AnagramaDTO result = anagramaService.isAnagrama(words);
        assertTrue(result.isAnagrama());
    }

    @Test
    public void testIsAnagramaDifferentLenght(){

        words.add("a");
        words.add("ab");

        AnagramaDTO result = anagramaService.isAnagrama(words);

        assertFalse(result.isAnagrama());
    }

    @Test
    public void testIsAnagramaDifferentCase(){
        words.add("Arroz");
        words.add("ZoRRa");
        AnagramaDTO result = anagramaService.isAnagrama(words);
        assertTrue(result.isAnagrama());
    }

    @Test
    public void testNotAnagram(){
        words.add("Strong");
        words.add("String");

        AnagramaDTO result = anagramaService.isAnagrama(words);
        assertFalse(result.isAnagrama());
    }
}
