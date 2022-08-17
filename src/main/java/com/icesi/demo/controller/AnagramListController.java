package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramListAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.implementation.AnagramListServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AnagramListController implements AnagramListAPI {

    private final AnagramListServiceImpl anagramListServiceImpl;

    @Override
    public AnagramResponseDTO isAnagram(@RequestBody List<String> stringList) {
        return anagramListServiceImpl.isAnagram(stringList);
    }


}
