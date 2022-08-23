package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramListAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramListService;
import com.icesi.demo.service.StringListService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnagramListController implements AnagramListAPI {
    private final AnagramListService anagramListService;

    public AnagramListController(AnagramListService anagramListService) {
        this.anagramListService = anagramListService;
    }

    private boolean validateNulls(List<String> stringList){
        for(int i=0; i<stringList.size();i++){
            if(stringList.get(i)==null){
                return false;
            }
        }

        return true;
    }

    private boolean validateSizes(List<String> stringList){
        int lenght = stringList.get(0).length();

        for(int i=1; i<stringList.size();i++){
            if(lenght!=stringList.get(i).length()){
                return false;
            }
        }
        return true;
    }
    private boolean validateList(List<String> stringList){

        if(stringList!= null && stringList.size()>1){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public AnagramResponseDTO isAnagram(List<String> stringList) {

        if(validateList(stringList)&&validateNulls(stringList)&&validateSizes(stringList)){
            return anagramListService.isAnagram(stringList);
        }
        return new AnagramResponseDTO(false);

    }
}
