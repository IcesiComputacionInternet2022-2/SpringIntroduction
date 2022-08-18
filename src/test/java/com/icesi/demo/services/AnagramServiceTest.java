package com.icesi.demo.services;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import com.icesi.demo.service.implementation.AnagramServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramServiceTest {

    private AnagramService anagramService;

    @BeforeEach
    private void init(){
        anagramService = new AnagramServiceImp();
    }
    @Test
    public void testAnagramString(){
        List<String> stringList = new ArrayList<String>();
        stringList.add("llenaba");
        stringList.add("ballena");

        AnagramResponseDTO result = anagramService.anagramString(stringList);

        assertTrue(result.isResult());
    }

    @Test
    public void testLenght(){
        List<String> stringList = new ArrayList<String>();
        stringList.add("llena");
        stringList.add("ballena");

        AnagramResponseDTO result = anagramService.anagramString(stringList);

        assertTrue(result.isResult());
    }

    @Test
    public void testUpperLowCase(){
        List<String> stringList = new ArrayList<String>();
        stringList.add("LLENABA");
        stringList.add("ballena");

        AnagramResponseDTO result = anagramService.anagramString(stringList);

        assertTrue(result.isResult());
    }

    @Test
    public void testAnangramStringFail(){
        List<String> stringList = new ArrayList<String>();
        stringList.add("String");
        stringList.add("Spring");

        AnagramResponseDTO result = anagramService.anagramString(stringList);

        assertFalse(result.isResult());
    }
}
