package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramaDTO;
import com.icesi.demo.service.AnagramaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class AnagramaServiceImpl implements AnagramaService {

    @Override
    public AnagramaDTO isAnagrama(List<String> list) {

            String word1 = list.get(0).toLowerCase();
            String word2 = list.get(1).toLowerCase();

            while (!word1.isEmpty() && word1.length() == word2.length()){
                String aux = word1.charAt(0)+"";
                word2 = word2.replaceAll(aux,"");
                word1 = word1.replaceAll(aux,"");
                System.out.println(word1);
                System.out.println(word2);
            }

            return new AnagramaDTO(word1.equals(word2));
            //strong
            //string
    }
}
