package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.dto.IsAnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import com.icesi.demo.service.StringListService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class AnagramServiceImpl implements AnagramService {

    @Override
    public IsAnagramResponseDTO isAnagram(List<String> words) {

        if(words.contains(null)){
            return new IsAnagramResponseDTO(false);
        }

        //Verifies if all strings have the same length
        int prevLength = words.get(0).length();
        for (String word:words){
            int newLength = word.length();
            if (prevLength != newLength){return new IsAnagramResponseDTO(false);}
        }

        String firstWord = words.get(0);
        for (int i = 0; i < firstWord.length(); i++){
            char currentLetter = firstWord.charAt(i);
            for (int j = 0; j < words.size(); j++){
                words.set(j,words.get(j).replaceFirst(Character.toString(currentLetter),""));
            }
        }

        for(String word: words){
            if(!word.equals("")){
                return new IsAnagramResponseDTO(false);
            }
        }


        return new IsAnagramResponseDTO(true);
    }
}
