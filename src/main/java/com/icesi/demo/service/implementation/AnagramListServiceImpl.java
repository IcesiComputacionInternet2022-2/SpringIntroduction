package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramListService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AnagramListServiceImpl implements AnagramListService {

    @Override
    public AnagramResponseDTO isAnagram(List<String> strings) {

//        Stream<String> filtred = strings.stream()
//                .filter(x -> x.matches("[a-z]*") && !x.matches("[^null$]"));
//
//        if(strings.size() != (int)filtred.count()) {
//            return new AnagramResponseDTO(false);
//        }

        String word = strings.get(0);
        int size = strings.size();

        for (int i = 1 ; i < strings.size() ; i++){
            if(areTwoWordsAnagram(word, strings.get(i)) == false){
                return new AnagramResponseDTO(false);   
            }
        }
        return new AnagramResponseDTO(true);
    }

    public boolean areTwoWordsAnagram(String a, String b){
        if(a.length() != b.length()){
            return false;
        }

        int[] counts = new int[26];
        for(int i = 0 ; i < a.length() ; i++){
            counts[a.charAt(i)-'a']++;
            counts[b.charAt(i)-'a']--;
        }

        for(int count: counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

}
