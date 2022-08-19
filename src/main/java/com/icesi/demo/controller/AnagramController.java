package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.implementation.AnagramServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AnagramController implements AnagramAPI {

    private final AnagramServiceImpl anagramService;

    @Override
    public AnagramResponseDTO anagramCheck(List<String> stringList) {
        return verifyStrings(stringList);
    }

    public AnagramResponseDTO verifyStrings(List<String> stringList){
        if(validateList(stringList) && validateElements(stringList)){
            return anagramService.anagramCheck(stringList);
        }else {
            return new AnagramResponseDTO(false);
        }
    }

    private boolean validateList(List<String> stringList){
        return !(stringList == null) && stringList.size() == 2;
    }

    private boolean validateElements(List<String> stringList){
        return stringList.stream().noneMatch(this::validateElement);
    }

    private boolean validateElement(String word){
        return !(word != null) && word.matches("[a-zA-Z]+");
    }
}