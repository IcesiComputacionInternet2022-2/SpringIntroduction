package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.StringListService;
import com.icesi.demo.service.implementation.AnagramServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AnagramController implements AnagramAPI {

    private final AnagramServiceImpl anagramService;

    @Override
    public AnagramResponseDTO anagramCheck(List<String> stringList) {
        return verifyStrings(stringList);
    }

    public AnagramResponseDTO verifyStrings(List<String> stringList){
        if(stringList.size() == 2){
            String p1 = stringList.get(0);
            String p2 = stringList.get(1);

            if(p1.length() == p2.length()) {
                if(p1.matches("^[a-zA-Z]+$") && p2.matches("^[a-zA-Z]+$")){
                    return anagramService.anagramCheck(stringList);
                }else{
                    return new AnagramResponseDTO(false);
                }
            }else{
                return new AnagramResponseDTO(false);
            }
        }else{
            return new AnagramResponseDTO(false);
        }
    }
}