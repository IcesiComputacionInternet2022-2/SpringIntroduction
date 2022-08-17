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
        String str1 = strings.get(0).toLowerCase();
        String str2 = strings.get(1).toLowerCase();
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        str1 = String.valueOf(charArray1);
        str2 = String.valueOf(charArray2);
        if(!str1.matches("[a-zA-Z]+") || !str2.matches("[a-zA-Z]+") || strings.size() > 2)
            return new AnagramResponseDTO(false);
        boolean result = str1.equalsIgnoreCase(str2);
        return new AnagramResponseDTO(result);
    }
}
