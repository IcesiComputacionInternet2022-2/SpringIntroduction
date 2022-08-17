package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramaAPI;
import com.icesi.demo.dto.AnagramaDTO;
import com.icesi.demo.service.AnagramaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
public class AnagramaController implements AnagramaAPI {

    private final AnagramaService service;

    @Override
    public AnagramaDTO areAnagrama(List<String> list) {
        return service.isAnagrama(list);
    }

    @Override
    public String getStatus() {
        return "Funciona!";
    }
}
