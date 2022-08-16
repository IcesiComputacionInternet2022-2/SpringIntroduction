package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramListAPI;
import com.icesi.demo.api.StringListAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.AnagramService;
import com.icesi.demo.service.StringListService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;


@RestController
public class AnagramController implements AnagramListAPI {

    private final AnagramService anagramService;

    public AnagramController(AnagramService anagramService) {
        this.anagramService = anagramService;
    }

    @Override
    public AnagramResponseDTO searchAnagram(List<String> stringList) {
        if(stringList.size() <= 1 || stringList.size() >= 3 || stringList.isEmpty() || stringList == null) {
            return new AnagramResponseDTO(false);
        } else if (stringList.get(0) == null || stringList.get(1) == null){
            return new AnagramResponseDTO(false);
        } else if (!stringList.get(0).matches("^[a-zA-Z]*$") || !stringList.get(1).matches("^[a-zA-Z]*$")) {
            return new AnagramResponseDTO(false);
        }
        return anagramService.searchAnagram(stringList);
    }

}
