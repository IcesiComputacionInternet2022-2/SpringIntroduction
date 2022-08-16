package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.dto.WordDTO;
import com.icesi.demo.service.StringListService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class AnagramaService {

    public boolean checkAnagram(List<String> mongus){

        boolean isAnAnagram = false;
        String word1 = mongus.get(0), word2=mongus.get(1);

        word1 = word1.toUpperCase();
        word2 = word2.toUpperCase();

        if(word1.length() == word2.length()){
            ArrayList<String> container = new ArrayList<>();


            for( int i = 0 ; i < word1.length() ; i++){
                container.add(word1.charAt(i)+"");
            }

            for( int i = 0 ; i < word1.length() ; i++){
                container.remove(word2.charAt(i)+"");
            }

            if(container.size() == 0){
                isAnAnagram = true;
            }
        }
        return isAnAnagram;
    }
}
