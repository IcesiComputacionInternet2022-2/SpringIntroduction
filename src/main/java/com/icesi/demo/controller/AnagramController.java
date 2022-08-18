package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AnagramController implements AnagramAPI {

    private final AnagramService anagramService;

    @Override
    public AnagramResponseDTO anagramResult(List<String> anagramsList) {
        if (validateList(anagramsList) && validateElements(anagramsList)) {
            return anagramService.anagramResult(anagramsList);
        }
        return new AnagramResponseDTO(false);
    }

    private boolean validateList(List<String> anagramsList) {
        return anagramsList != null && anagramsList.size() == 2;
    }

    private boolean validateElements(List<String> anagramsList) {
        return anagramsList.stream().allMatch(this::validateElement);
    }

    private boolean validateElement(String word) {
        return word != null && word.matches("[a-zA-Z]+");
    }
}
