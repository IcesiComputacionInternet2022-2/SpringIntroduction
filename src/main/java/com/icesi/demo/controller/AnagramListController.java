package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramListAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramListService;
import com.icesi.demo.service.StringListService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnagramListController implements AnagramListAPI {
    private final AnagramListService anagramListService;

    public AnagramListController(AnagramListService anagramListService) {
        this.anagramListService = anagramListService;
    }

    @Override
    public AnagramResponseDTO isAnagram(List<String> stringList) {
        return anagramListService.isAnagram(stringList);
    }
}
