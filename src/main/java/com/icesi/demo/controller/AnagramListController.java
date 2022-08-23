package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramListAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramListService;
import com.icesi.demo.service.implementation.AnagramListServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AnagramListController implements AnagramListAPI {

    private final AnagramListService anagramListService; //acá es el service no la implementación

    @Override
    public AnagramResponseDTO isAnagram(@RequestBody List<String> stringList) {



        if (!validateList(stringList)){
            return new AnagramResponseDTO(false);
        }else{
            if(!validateElements(stringList)){
                return new AnagramResponseDTO(false);
            }else{
                return anagramListService.isAnagram(stringList);
            }
        }
    }


    private boolean validateList(List<String> stringList){
        return stringList!=null && stringList.size()==2;
    }

    private boolean validateElements(List<String> stringList){
        boolean isValid=true;

        for(String word:stringList){
            isValid=validateElement(word);
            if (!isValid){
                break;
            }
        }

        return isValid;

    }

    private boolean validateElement(String word){
        return word!=null && word.matches("^[a-zA-Z]*$");
    }





}
