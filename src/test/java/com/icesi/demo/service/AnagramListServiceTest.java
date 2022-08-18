package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.implementation.AnagramListServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramListServiceTest {

    private AnagramListService anagramListService; //Probamos la interfaz, no necesariamente la implementación

    @BeforeEach //se llama solo este método gracias al beforeeach
    private void init(){
        anagramListService = new AnagramListServiceImpl();
    }

    @Test
    public void testIsAnagram(){
        List<String> stringList= new ArrayList<>();
        stringList.add("listen");
        stringList.add("silent");

        AnagramResponseDTO result= anagramListService.isAnagram(stringList);

        assertTrue(result.isResult());

    }

    @Test
    public void testIsNotAnagram(){
        List<String> stringList= new ArrayList<>();
        stringList.add("listsen");
        stringList.add("silent");

        AnagramResponseDTO result= anagramListService.isAnagram(stringList);

        assertFalse(result.isResult());
    }

    @Test
    public void testAnagramCaseInsensitive(){
        List<String> stringList= new ArrayList<>();
        stringList.add("listEn");
        stringList.add("siLent");

        AnagramResponseDTO result= anagramListService.isAnagram(stringList);

        assertTrue(result.isResult());
    }

    @Test
    public void testAnagramCaseSameQuantyLetters(){
        List<String> stringList= new ArrayList<>();
        stringList.add("listEn");
        stringList.add("siLentq");

        AnagramResponseDTO result= anagramListService.isAnagram(stringList);

        assertFalse(result.isResult());
    }

}
