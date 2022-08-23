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
        //Verifies if all strings have the same length
        int expectedLength = words.get(0).length();
        for (String word:words){
            if (word.length() != expectedLength){return new IsAnagramResponseDTO(false);}
        }

        for (int i = 0; i < words.size();i++){
            words.set(i,words.get(i).toLowerCase());
        }


        //Looks for letters of the first word and removes them until there are no more letters
        String firstWord = words.get(0);
        for (int i = 0; i < firstWord.length(); i++){
            char currentLetter = firstWord.charAt(i);
            for (int j = 0; j < words.size(); j++){
                words.set(j,words.get(j).replaceFirst(Character.toString(currentLetter),""));
            }
        }

        //If a word is not "" or equally does not have length 0 then at least 1 word is not an anagram
        for(String word: words){
            if(word.length() != 0){
                return new IsAnagramResponseDTO(false);
            }
        }

        return new IsAnagramResponseDTO(true);
    }
}
