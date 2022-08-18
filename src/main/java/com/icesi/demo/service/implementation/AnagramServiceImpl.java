package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnagramServiceImpl implements AnagramService {
    @Override
    public AnagramResponseDTO anagram(List<String> stringList) {
        String word1 = stringList.get(0).toLowerCase(), word2 = stringList.get(1).toLowerCase();
        boolean length = word1.length() == word2.length();
        for (int i = 0; i < word1.length() && length; i++)
            word2 = word2.contains(String.valueOf(word1.charAt(i))) ? word2.replaceFirst(String.valueOf(word1.charAt(i)), "") : word2;
        return new AnagramResponseDTO(word2.equals("") && length);
    }
}
