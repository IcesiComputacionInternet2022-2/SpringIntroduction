package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramListService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AnagramListServiceImpl implements AnagramListService {

    /*
     * Check if a list of words are anagrams using maps
     * @param strings List of words to check
     * @return booleanDTO indicating weather words are anagram or not
     * @author nicolaspenagos
     */
    @Override
    public AnagramResponseDTO isAnagram(List<String> strings) {

        //We need at least two words
        if(strings.size()<2){
            return new AnagramResponseDTO(false);
        }

        List<HashMap<Character, Integer>> maps = new ArrayList<>();
        String currentWord = "";

        // For each word...
        for(int i=0; i<strings.size();i++){

            currentWord = strings.get(i);

            // 1. check that there are no nulls
            if(currentWord==null){
                return new AnagramResponseDTO(false);
            }

            // 2. check that all sizes are the same
            if(strings.get(0).length()!=currentWord.length()){
                return new AnagramResponseDTO(false);
            }

            // 3. eliminate case sensitivity
            currentWord = currentWord.toUpperCase();

            // 4. Mapping every character in each word
            HashMap<Character, Integer> map = new HashMap<>();

            for(int j=0; j<currentWord.length();j++){
                char key = currentWord.charAt(j);
                if(map.containsKey(key)){
                    int counter = map.get(key) + 1;
                    map.put(key, counter);
                }else{
                    map.put(key, 1);
                }
            }
            maps.add(map);
        }

        // 5. Check all maps to be equal
        for (int i=1; i<maps.size(); i++){
            if(!maps.get(0).equals(maps.get(i))){
                return new AnagramResponseDTO(false);
            }
        }

        return new AnagramResponseDTO(true);
    }




}
