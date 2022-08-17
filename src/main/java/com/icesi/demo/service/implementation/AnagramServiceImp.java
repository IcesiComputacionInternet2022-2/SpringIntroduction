package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AnagramServiceImp implements AnagramService {

    @Override
    public AnagramResponseDTO anagramString(List<String> words){
        String cad1 = words.get(0);
        String cad2 = words.get(1);

        boolean c1 = cad1.matches("[+-]?\\d*(\\.\\d+)?");
        boolean c2 = cad2.matches("[+-]?\\d*(\\.\\d+)?");

        System.out.println(c1);
        System.out.println(c2);


        AnagramResponseDTO responseDTO = new AnagramResponseDTO(false);

        if(!c1 && !c2){
            cad1 = sort(cad1.toUpperCase());
            cad2 = sort(cad2.toUpperCase());
            responseDTO.setResult(cad1.equals(cad2));
            System.out.println(responseDTO.isResult());

        }

        return responseDTO;
    }

    private String sort(String cadena) {
        char[] aux = cadena.toCharArray();
        Arrays.sort(aux);
        return new String(aux);
    }
}
