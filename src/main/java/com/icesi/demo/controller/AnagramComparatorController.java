package com.icesi.demo.controller;


import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.BooleanResultService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AnagramComparatorController implements AnagramAPI {

    private final BooleanResultService booleanResultService;

    @Override
    public AnagramResponseDTO anagramComparator(List<String> list) {
        return booleanResultService.anagramComparator(list);
    }


}
