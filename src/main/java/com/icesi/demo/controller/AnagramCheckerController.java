package com.icesi.demo.controller;


import com.icesi.demo.api.AnagramCheckerAPI;
import com.icesi.demo.dto.AnagramCheckerResponseDTO;
import com.icesi.demo.service.AnagramCheckerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AnagramCheckerController implements AnagramCheckerAPI {

    private final AnagramCheckerService anagramCheckerServiceImpl;

    @Override
    public AnagramCheckerResponseDTO checkAnagram(@RequestBody List<String> stringList) {
        if(verifyNull(stringList) && verifyContent(stringList) && verifySize(stringList))
            return anagramCheckerServiceImpl.checkAnagram(stringList);
        else
            return new AnagramCheckerResponseDTO(false);
    }

    private boolean verifyNull(List<String> stringList) {
        return stringList != null;
    }

    private boolean verifyContent(List<String> stringList) {
        return !stringList.contains(null);
    }

    private boolean verifySize(List<String> stringList) {
        return stringList.size() == 2;
    }

}
