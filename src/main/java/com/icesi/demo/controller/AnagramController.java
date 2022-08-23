package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.dto.ConfirmationDTO;
import com.icesi.demo.service.AnagramService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AnagramController implements AnagramAPI{

    private final AnagramService anagramService;


    @Override
    public ConfirmationDTO checkAnagrams(List<String> stringList) {
        if(validList(stringList) && validElements(stringList) && validElementFormat(stringList)){
            return anagramService.checkAnagrams(stringList);
        }
        else{
            return new ConfirmationDTO(false);
        }
    }

    private boolean validList(List<String> stringList) {
        return stringList != null && stringList.size() == 2;
    }

    private boolean validElements(List<String> stringList) {
        return stringList.get(0) != null && stringList.get(1) != null;
    }

    private boolean validElementFormat(List<String> stringList) {
        return stringList.get(0).matches("^[a-zA-Z]*$") && stringList.get(1).matches("^[a-zA-Z]*$");
    }

}
