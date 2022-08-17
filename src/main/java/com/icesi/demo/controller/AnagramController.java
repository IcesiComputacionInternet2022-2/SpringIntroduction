package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AnagramController implements AnagramAPI {

    private final AnagramService anagramService;

    @Override
    public AnagramResponseDTO isAnagram(List<String> strings) {
        if (strings.size() == 2 && !strings.contains(null)) {
            if (strings.get(0).length() == strings.get(1).length()) {
                for (String string : strings) {
                    if (!string.matches("[a-zA-Z]+"))
                        return new AnagramResponseDTO(false);
                }
                return anagramService.isAnagram(strings.get(0).toLowerCase(), strings.get(1).toLowerCase());
            }
        }
        return new AnagramResponseDTO(false);
    }
}
