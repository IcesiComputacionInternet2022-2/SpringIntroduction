package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramListAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AnagramListController implements AnagramListAPI {

    public final AnagramListService anagramListService;

    @Override
    public AnagramResponseDTO isAnagram(List<String> strings) {
        if(validateList(strings) == false){
            return new AnagramResponseDTO(false);
        }else if(validateElements(strings) == false){
            return new AnagramResponseDTO(false);
        }else{
            return anagramListService.isListAnagram(strings);
        }
    }

    private boolean validateList(List<String> stringList){
        return stringList != null && stringList.size() > 1;
    }

    private boolean validateElements(List<String> stringList){
        return stringList.stream().allMatch(s -> s != null && s.matches("[a-z]*"));
    }

}
