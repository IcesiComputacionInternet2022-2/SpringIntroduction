package com.icesi.demo.controller;

import com.icesi.demo.api.AnagramAPI;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import com.icesi.demo.service.StringListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AnagramController implements AnagramAPI{
    private final AnagramService anagramService;

    @Override
    public AnagramResponseDTO checkAnagram(List<String> stringList) {
        if(checkList(stringList) && checkNotNullElements(stringList) && checkSameElementsLength(stringList)){
            return anagramService.checkAnagram(stringList);
        }//End if
        return new AnagramResponseDTO(false);
    }//End isAnagram

    private boolean checkList(List<String> stringList){
        return stringList != null && stringList.size() == 2 ;
    }//End checkList

    private boolean checkNotNullElements(List<String> stringList){
        return stringList.get(0) != null && stringList.get(1) != null;
    }//End checkListElements

    private boolean checkSameElementsLength(List<String> stringList){
        return stringList.get(0).length() == stringList.get(1).length();
    }//End checkSameElementsLength

}
