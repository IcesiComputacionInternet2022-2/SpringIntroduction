package com.icesi.demo.controller;

import com.icesi.demo.api.StringListAPI;
import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.StringListService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StringListController implements StringListAPI {

    private final StringListService stringListService;

    public StringListController(StringListService stringListService) {
        this.stringListService = stringListService;
    }

    @Override
    public ConcatenatedResponseDTO concatenateStrings(List<String> stringList) {
        return stringListService.concatenateStrings(stringList);
    }

}
