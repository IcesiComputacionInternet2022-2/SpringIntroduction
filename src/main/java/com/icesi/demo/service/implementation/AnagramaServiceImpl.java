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
        String regExp = "[aA-zZ]+";

        if (Pattern.matches(regExp,list.get(0)) && Pattern.matches(regExp,list.get(1))){
            String a = list.get(0), b = list.get(1);
            a = a.toLowerCase();
            b = b.toLowerCase();

            while (!a.isEmpty() && a.length() == b.length()){
                b = b.replaceAll(a.charAt(0)+"","");
                a = a.replaceAll(a.charAt(0)+"","");
            }

            return new AnagramaDTO(a.equals(b));
        }else{
            return new AnagramaDTO(false);
        }

    }
}
