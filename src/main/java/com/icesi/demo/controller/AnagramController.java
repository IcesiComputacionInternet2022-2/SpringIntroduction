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
    public AnagramResponseDTO isAnagram(List<String> strings) {
        return anagramService.isAnagram(strings);
    }
}
