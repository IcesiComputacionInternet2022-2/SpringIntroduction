package service;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import com.icesi.demo.service.implementation.AnagramServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramServiceTest {

    private AnagramService anagramService;

    @BeforeEach
    private void init() {
        anagramService = new AnagramServiceImpl();
    }

    @Test
    public void testIsAnagram() {
        List<String> stringList = new ArrayList<>();
        stringList.add("listen");
        stringList.add("silent");
        AnagramResponseDTO result = anagramService.isAnagram(stringList);
        assertTrue(result.isResult());
    }

    @Test
    public void testIsAnagramLengthIsDifferent() {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("ab");
        AnagramResponseDTO result = anagramService.isAnagram(stringList);
        assertFalse(result.isResult());
    }

    @Test
    public void testIsAnagramCaseInsensitive() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Listen");
        stringList.add("Silent");
        AnagramResponseDTO result = anagramService.isAnagram(stringList);
        assertTrue(result.isResult());
    }

    @Test
    public void testIsNotAnagram() {
        List<String> stringList = new ArrayList<>();
        stringList.add("String");
        stringList.add("Strong");
        AnagramResponseDTO result = anagramService.isAnagram(stringList);
        assertFalse(result.isResult());
    }

    @Test
    public void testIsAnagramRepeatedLetters(){
        List<String> stringList = new ArrayList<>();
        stringList.add("listen");
        stringList.add("sillent");
        AnagramResponseDTO result = anagramService.isAnagram(stringList);
        assertFalse(result.isResult());
    }
}
