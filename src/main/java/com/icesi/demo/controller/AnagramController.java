package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AnagramController implements AnagramAPI {

    private final AnagramService anagramService;
    @Override
    public AnagramResponseDTO anagramString(@NotNull List<String> stringList) {

        return stringList.size() !=2 ?
                new AnagramResponseDTO(false) :
                anagramService.anagramString(stringList.get(0), stringList.get(1));
    }

}
