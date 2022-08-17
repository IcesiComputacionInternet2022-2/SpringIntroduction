package com.icesi.demo.controller;

import com.icesi.demo.api.StringListAPI;
import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.implementation.StringListServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AnagramController implements StringListAPI {

    private final StringListServiceImpl stringListService;



    @Override
    public ConcatenatedResponseDTO concatenateStrings(List<String> stringList) {
        return stringListService.concatenateStrings(stringList);
    }

}
