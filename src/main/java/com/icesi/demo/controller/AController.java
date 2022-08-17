package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.dto.AnagramDTO;
import com.icesi.demo.service.AnagramService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AController implements AnagramAPI {

    private AnagramService anagramService;



    @Override
    public AnagramDTO isAnagram(List<String> stringList) {

        return anagramService.isAnagram(stringList.get(1), stringList.get(2));
    }
}
