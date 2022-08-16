package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class AnagramServiceImpl implements AnagramService {

    @Override
    public AnagramResponseDTO anagramCheck(List<String> stringList) {
        String p1 = stringList.get(0).toLowerCase();
        String p2 = stringList.get(1).toLowerCase();

        for(int i = 0; i < p1.length(); i++){
            p2 = p2.replace(p1.charAt(i),' ');
        }

        if(p2.trim().equalsIgnoreCase("")){
            return new AnagramResponseDTO(true);
        }else{
            return new AnagramResponseDTO(false);
        }
    }
}
