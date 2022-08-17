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
        String cad1 = words.get(0).toUpperCase();
        String cad2 = words.get(1).toUpperCase();

        cad1 = sort(cad1);
        cad2 = sort(cad2);

        return new AnagramResponseDTO(cad1.equals(cad2));
    }

    private String sort(String cadena) {
        char[] aux = cadena.toCharArray();
        Arrays.sort(aux);
        return new String(aux);
    }
}
