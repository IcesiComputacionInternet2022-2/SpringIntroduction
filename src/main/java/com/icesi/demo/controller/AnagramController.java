package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.api.StringListAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.AnagramService;
import com.icesi.demo.service.StringListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AnagramController implements AnagramAPI {

    private final AnagramService anagramService;

    @Override
    public AnagramResponseDTO findAnagram(String str1, String str2) {
        if(validateString(str1) && validateString(str2))
            return anagramService.findAnagram(str1, str1);
        return new AnagramResponseDTO(false);
    }

    private boolean validateString(String string) {
        return string != null && string.matches("[a-zA-Z]+");
    }

}
