package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AnagramController implements AnagramAPI {

    private AnagramService anagramService;

    @Override
    public AnagramResponseDTO isAnagram(List<String> stringList) {
        if(validateList(stringList) && validateElements(stringList))
            return anagramService.isAnagram(stringList);
        return new AnagramResponseDTO(false);
    }

    private boolean validateList(List<String> stringList) {
        return stringList != null && stringList.size() == 2;
    }

    private boolean validateElements(List<String> stringList) {
        return validateElement(stringList.get(0)) && validateElement(stringList.get(1));
    }

    private boolean validateElement(String word) {
        return word != null && word.matches("[a-zA-Z]+");
    }
}
