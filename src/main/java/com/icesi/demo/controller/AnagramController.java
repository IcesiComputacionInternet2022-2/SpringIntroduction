package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramApi;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import com.icesi.demo.service.StringListService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnagramController implements AnagramApi {

    private final AnagramService anagramService;

    public AnagramController(AnagramService anagramService) {
        this.anagramService = anagramService;
    }

    @Override
    public AnagramResponseDTO anagramString(List<String> words){
        return anagramService.anagramString(words);
    }

}
