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
        if (validList(stringList) && validElements(stringList)) return anagramService.isAnagram(stringList);
        return false;
    }

    private boolean validList(List<String> stringList) {
        return stringList != null && stringList.size() == 2;
    }

    private boolean validElements(List<String> stringList) {
        return stringList.get(0) != null && stringList.get(1) != null && !stringList.get(0).matches(".*[0-9]+.*") && !stringList.get(1).matches(".*[0-9]+.*");
    }
}
