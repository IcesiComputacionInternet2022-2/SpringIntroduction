package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramaStringAPI;
import com.icesi.demo.api.StringListAPI;
import com.icesi.demo.dto.AnagramaResponseDTO;
import com.icesi.demo.service.implementation.AnagramaStringServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@AllArgsConstructor
public class AnagramaStringController implements AnagramaStringAPI {

    private final AnagramaStringServicesImpl anagramaStringServices;

    @Override
    public AnagramaResponseDTO angramaStrings(List<String> stringList) {

        if(stringList.size() != 2 || stringList.isEmpty() || stringList == null){
            return new AnagramaResponseDTO(false);
        }else if (stringList.get(0) == null || stringList.get(1) == null){
            return new AnagramaResponseDTO(false);
        } else if (!stringList.get(0).matches("^[a-zA-Z]*$") || !stringList.get(1).matches("^[a-zA-Z]*$")) {
            return new AnagramaResponseDTO(false);
        }
        return anagramaStringServices.anagramaStrings(stringList);
    }
}
