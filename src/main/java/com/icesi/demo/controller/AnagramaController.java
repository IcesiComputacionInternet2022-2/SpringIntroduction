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

        if (validateList(list) && validateElements(list)) return service.isAnagrama(list);
        return new AnagramaDTO(false);
    }

    public boolean validateList(List<String> list){
        return list != null  && list.size() == 2;
    }


    public boolean validateElements(List<String> list){
        return list.stream().allMatch(this::validateElement);
    }
    public boolean validateElement(String word){
        return word != null && word.matches("[aA-zZ]+");
    }
}
