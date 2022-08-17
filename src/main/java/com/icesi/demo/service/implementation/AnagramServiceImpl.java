package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramDTO;
import com.icesi.demo.service.AnagramService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AnagramServiceImpl implements AnagramService {
    @Override
    public String order(String s1) {
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    @Override
    public AnagramDTO isAnagram(String s1, String s2) {
        s1 = s1.toLowerCase().replace(" ", "").replace(".", "").replace(",", "").replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        s2 = s2.toLowerCase().replace(" ", "").replace(".", "").replace(",", "").replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        s1 = order(s1);
        s1 = order(s1);

        return new AnagramDTO(s1.equals(s1));
    }
}
