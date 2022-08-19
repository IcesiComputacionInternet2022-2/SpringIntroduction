package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.implementation.AnagramServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramServiceTest {

    private AnagramServiceImpl anagramService;

    @BeforeEach
    private void init(){
        anagramService = new AnagramServiceImpl();

    }

    /**Por qué mi metodo para obtener el valor booleano almacenado dentro del AnagramResponseDTO se nombra
     * get result en vez de is result
     * (Teoria): Inicialmente mi variable era String y por eso se quedo con el get**/
    @Test
    public void testAnagramCheck(){
        List<String> stringList = new ArrayList<>();
        stringList.add("listen");
        stringList.add("silent");

        AnagramResponseDTO result = anagramService.anagramCheck(stringList);
        assertTrue(result.getResult());anagramService.anagramCheck(stringList);
    }

    @Test
    public void testIsAnagramLengthIsDifferent() {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("ab");
        AnagramResponseDTO result = anagramService.anagramCheck(stringList);
        assertFalse(result.getResult());
    }

    @Test
    public void testIsAnagramCaseInsensitive() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Listen");
        stringList.add("Silent");
        AnagramResponseDTO result = anagramService.anagramCheck(stringList);
        assertTrue(result.getResult());
    }

    @Test
    public void testIsNotAnagram() {
        List<String> stringList = new ArrayList<>();
        stringList.add("String");
        stringList.add("Strong");
        AnagramResponseDTO result = anagramService.anagramCheck(stringList);
        assertFalse(result.getResult());
    }

    @Test
    public void testIsAnagramRepeatedLetters(){
        List<String> stringList = new ArrayList<>();
        stringList.add("listen");
        stringList.add("sillent");
        AnagramResponseDTO result = anagramService.anagramCheck(stringList);
        assertFalse(result.getResult());
    }
}
