package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@AllArgsConstructor
@RestController
public class AnagramController implements AnagramAPI {

    private final AnagramService anagramService;

    @Override
    public AnagramResponseDTO isAnagram(List<String> strings) {
        if (validateList(strings) && validateElements(strings)) {
            if (validateElement(strings))
                return anagramService.isAnagram(strings.get(0), strings.get(1));
        }
        return new AnagramResponseDTO(false);
    }

    private boolean validateList(List<String> stringList) {
        return stringList != null && stringList.size() == 2;
    }

    private boolean validateElements(List<String> stringList) {
        return !stringList.contains(null);
    }

    private boolean validateElement(List<String> stringList) {
        return stringList.get(0).matches("[a-zA-Z]+") && stringList.get(1).matches("[a-zA-Z]+");
    }
}
