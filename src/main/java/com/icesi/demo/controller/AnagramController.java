package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.dto.ConfirmationDTO;
import com.icesi.demo.service.AnagramService;
import com.icesi.demo.service.StringListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AnagramController implements AnagramAPI{

    private final AnagramService anagramService;


    @Override
    public ConfirmationDTO checkAnagrams(List<String> stringList) {
        return null;
    }
}
