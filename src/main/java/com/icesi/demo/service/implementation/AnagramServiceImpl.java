package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AnagramServiceImpl implements AnagramService {

    @Override
    public AnagramResponseDTO isAnagram(List<String> strings) {
        String word1 = strings.get(0).toLowerCase();
        String word2 = strings.get(1).toLowerCase();
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        word1 = String.valueOf(charArray1);
        word2 = String.valueOf(charArray2);
        boolean result = word1.equalsIgnoreCase(word2);
        return new AnagramResponseDTO(result);
    }
}
