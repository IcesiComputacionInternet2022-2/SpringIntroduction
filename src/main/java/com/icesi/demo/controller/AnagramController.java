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
    private final AnagramServiceImpl anagramServiceImpl;
    @Override
    public AnagramResponseDTO anagram(List<String> stringList) {
        if (validateList(stringList) && validateElements(stringList) && validateElement(stringList))
            return anagramServiceImpl.anagram(stringList);
        return new AnagramResponseDTO(false);
    }

    private boolean validateList(List<String> stringList){
        return stringList != null && stringList.size() == 2;
    }

    private boolean validateElements(List<String> stringList){
        return stringList.get(0) != null && stringList.get(1) != null;
    }

    private  boolean validateElement(List<String> stringList){
        return stringList.get(0).matches("^[a-zA-Z]*$") && stringList.get(1).matches("^[a-zA-Z]*$");
    }
}
