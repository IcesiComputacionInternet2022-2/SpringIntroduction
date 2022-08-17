package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.List;
@Service
public class AnagramServiceImpl implements AnagramService{

    @Override
    public AnagramResponseDTO checkAnagram(List<String> stringList) {
        boolean response = false;
        if(stringList.size() == 2){
            if(stringList.get(0) != null && stringList.get(1) != null && stringList.get(0).length() == stringList.get(1).length()){
                if(!stringList.get(0).matches(".*\\d.*") && !stringList.get(1).matches(".*\\d.*")){
                    char[] f = stringList.get(0).toCharArray();
                    Arrays.sort(f);
                    char[] s = stringList.get(1).toCharArray();
                    Arrays.sort(s);
                    response = String.valueOf(f).equalsIgnoreCase(String.valueOf(s));
                }
            }
        }//End if
        return new AnagramResponseDTO(response);
    }
}
