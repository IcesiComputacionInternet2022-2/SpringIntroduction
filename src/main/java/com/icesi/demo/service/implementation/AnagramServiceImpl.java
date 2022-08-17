package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class AnagramServiceImpl implements AnagramService {

    @Override
    public AnagramResponseDTO anagramString(String str1, String str2) {
        boolean isAnagram = false;
        isAnagram = cleanString(str1).equals(cleanString(str2));
        return new AnagramResponseDTO(isAnagram);
    }
    public String cleanString(String str){
        return Arrays.stream(str.replaceAll("\\[\\^\\w]g", "").toLowerCase().split("")).sorted().collect(Collectors.joining());
    }
}
