package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnagramServiceImpl implements AnagramService {

    @Override
    public AnagramResponseDTO anagramCheck(List<String> stringList) {

        String p1 = stringList.get(0);
        String p2 = stringList.get(1);
        String response = "";

        if(p1.length() == p2.length()){
            for(int i = 0; i < p1.length(); i++){
                char x = p1.charAt(i);
                p2 = p2.replace(x,' ');
            }

            if(p2.trim().equalsIgnoreCase("")){
                response = "Anagrama";
            }else{
                response = "No anagrama";
            }
        }else{
            response = "Diferente tamaño";
        }
        return new AnagramResponseDTO(response);
    }
}
