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
        if (anagramsList.size() > 0 && anagramsList.size() <= 2 && anagramsList.stream().allMatch(s -> s != null && s.matches("[a-zA-Z]+"))) {
            return anagramService.anagramResult(anagramsList);
        }
        return new AnagramResponseDTO(false);
    }
}
