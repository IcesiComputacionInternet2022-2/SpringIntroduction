package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.api.StringListAPI;
import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.dto.IsAnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import com.icesi.demo.service.StringListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnagramController implements AnagramAPI {

    private final AnagramService anagramService;

    //Can be replaced with @AllArgsConstructor
    public AnagramController(AnagramService anagramService){
        this.anagramService = anagramService;
    }

    @Override
    public IsAnagramResponseDTO isAnagram(List<String> words) {
        if(validateList(words) && validateElements(words) && validateElementsHaveValidCharacters(words)){
            return anagramService.isAnagram(words);
        }
        return new IsAnagramResponseDTO(false);
    }

    private boolean validateList(List<String> words){
        return words != null && words.size() >= 2;
    }

    private boolean validateElements(List<String> words){
        //verifies if has null elements
        return !words.contains(null) && !words.contains("");
    }

    private boolean validateElementsHaveValidCharacters(List<String> words){
        for(String word: words){
            if(!word.matches("^[a-zA-z]*$")){return false;}
        }
        return true;
    }

}
