package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.api.StringListAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.AnagramService;
import com.icesi.demo.service.StringListService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AnagramController implements AnagramAPI {

    private final AnagramService anagramService;

    public AnagramController(AnagramService anagramService) {
        this.anagramService = anagramService;
    }

    @Override
    public AnagramResponseDTO isAnagram(List<String> stringList) {
        return anagramService.isAnagram(stringList);
    }

}
