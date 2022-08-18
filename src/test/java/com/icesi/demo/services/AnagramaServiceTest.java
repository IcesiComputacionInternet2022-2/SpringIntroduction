package com.icesi.demo.services;

import com.icesi.demo.dto.AnagramaResponseDTO;
import com.icesi.demo.service.AnagramaStringServices;
import com.icesi.demo.service.implementation.AnagramaStringServicesImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramaServiceTest {
    private AnagramaStringServices anagramaStringServices;

    @BeforeEach
    private void init(){
        anagramaStringServices = new AnagramaStringServicesImpl();

    }

    @Test
    public void testIsAnagram(){
        List<String> stringList = new ArrayList<>();
        stringList.add("Listen");
        stringList.add("Silent");
        AnagramaResponseDTO result = anagramaStringServices.anagramaStrings(stringList);
        assertTrue(result.isResult());
    }

    @Test
    public void testAnagramWordsLengthIsDifferent(){
        List<String> stringList = new ArrayList<>();
        stringList.add("silent");
        stringList.add("sillent");
        AnagramaResponseDTO result = anagramaStringServices.anagramaStrings(stringList);
        assertFalse(result.isResult());
    }
    @Test
    public void testOneIsLongerThanTheSecond(){
        List<String> stringList = new ArrayList<>();
        stringList.add("sillent");
        stringList.add("silent");
        AnagramaResponseDTO result = anagramaStringServices.anagramaStrings(stringList);
        assertFalse(result.isResult());
    }
    @Test
    public void noAnagram(){
        List<String> stringList = new ArrayList<>();
        stringList.add("String");
        stringList.add("Strong");
        AnagramaResponseDTO result = anagramaStringServices.anagramaStrings(stringList);
        assertFalse(result.isResult());
    }
}
