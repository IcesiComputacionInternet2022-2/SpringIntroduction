package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class AnagramServiceImpl implements AnagramService {
    public AnagramResponseDTO searchAnagram(List<String> stringList) {

        String word1 = stringList.get(0).trim().toLowerCase();
        String word2 = stringList.get(0).trim().toLowerCase();
        int contador2=0;

        for(int contador=0;contador<word1.length();contador++) {

            for(int contador1=0;contador1<word1.length();contador1++) {

                if(word1.charAt(contador)==word2.charAt(contador1)) {
                    ++contador2;

                }

            }
        }

        if(contador2==word1.length()) {
            return new AnagramResponseDTO(true);
        }else {
            return new AnagramResponseDTO(false);
        }
    }
}
