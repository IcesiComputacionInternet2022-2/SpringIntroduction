package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramApi;
import com.icesi.demo.api.StringListAPI;
import com.icesi.demo.dto.AnagramDTO;
import com.icesi.demo.service.AnagramService;
import com.icesi.demo.service.implementation.AnagramServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AnagramController implements AnagramApi {

    private final AnagramServiceImpl anagramList;



    public AnagramDTO anagramTwoWords(List<String> stringList) {
        if(validatedList(stringList) && validatedElement(stringList)) {
            return anagramList.anagramTwoWords(stringList);
        } else {return new AnagramDTO(false);}
    }

    private boolean validatedList(List<String> stringList) {
        return stringList != null && stringList.size() == 2;
    }

    private boolean validatedElement(List<String> stringList) {
        return stringList.stream().allMatch(this::validatedWord);
    }

    private boolean validatedWord(String word) {
        return word != null && word.matches("^[a-zA-Z]*$");
    }

}
