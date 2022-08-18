package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.service.AnagramService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@AllArgsConstructor
@RestController
public class AnagramController implements AnagramAPI {

    private final AnagramService anagramService;

    @Override
    public boolean checkAnagram(List<String> stringList) {
        int originalSize = stringList.size();
        stringList.removeIf(Objects::isNull); //Take nulls away
        stringList.removeIf(s -> Pattern.matches("[0-9]", s)); //Take nums away
        if (stringList.size() != 2 || originalSize != 2) return false;
        return anagramService.isAnagram(stringList);
    }
}
