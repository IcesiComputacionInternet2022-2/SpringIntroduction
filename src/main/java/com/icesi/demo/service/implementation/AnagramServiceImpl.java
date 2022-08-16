package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AnagramServiceImpl implements AnagramService{
    @Override
    public AnagramResponseDTO isAnagram(List<String> stringList) {
        boolean isAnagram = false;
        char[] arrayA = stringList.get(0).toLowerCase().toCharArray();
        char[] arrayB = stringList.get(1).toLowerCase().toCharArray();

        if(arrayA.length == arrayB.length){
            Arrays.sort(arrayA);
            Arrays.sort(arrayB);
            isAnagram = Arrays.equals(arrayA, arrayB);
        }

        return new AnagramResponseDTO(isAnagram);
    }
}
