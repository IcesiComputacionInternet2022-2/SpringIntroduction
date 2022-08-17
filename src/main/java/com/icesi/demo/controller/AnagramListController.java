package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramListAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AnagramListController implements AnagramListAPI {

    public final AnagramListService anagramListService;


    @Override
    public AnagramResponseDTO isAnagram(List<String> strings) {
        return anagramListService.isAnagram(strings);
    }
}
