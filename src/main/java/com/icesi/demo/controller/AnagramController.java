package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.StringListService;
import com.icesi.demo.service.implementation.AnagramServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AnagramController implements AnagramAPI {

    private final AnagramServiceImpl anagramService;

    @Override
    public AnagramResponseDTO anagramCheck(List<String> stringList) {
        return null;
    }
}
