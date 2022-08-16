package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramaAPI;
import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.dto.WordDTO;
import com.icesi.demo.service.StringListService;
import com.icesi.demo.service.implementation.AnagramaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AnagramaController implements AnagramaAPI {

    private final AnagramaService anagrama;




    @Override
    public WordDTO WordDTO(List<String> stringList) {
        return new WordDTO(anagrama.checkAnagram(stringList));
    }
}
