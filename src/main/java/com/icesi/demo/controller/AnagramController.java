package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import com.icesi.demo.service.implementation.AnagramServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AnagramController implements AnagramAPI{

    private final AnagramServiceImpl anagramService;

    @Override
    public AnagramResponseDTO isAnagram(List<String> stringList) {
        if (stringList.contains(null) || stringList.size() != 2 || !stringList.stream().allMatch(string -> string.matches("[a-zA-Z]+"))){
            return new AnagramResponseDTO(false);
        }
        return anagramService.isAnagram(stringList);
    }
}
