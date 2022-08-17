package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class AnagramServiceImpl implements AnagramService {

    @Override
    public AnagramResponseDTO isAnagram(List<String> stringList) {

        boolean response;

        if (stringList.size()<3){
            if (stringList.get(0)!=null && stringList.get(1)!=null){
                String w1 = stringList.get(0);
                String w2 = stringList.get(1);
                if (w1.length()==w2.length()){
                    w1=sort(w1);
                    w2=sort(w2);
                    if(w1.equals(w2)) response = true;
                    else response=false;
                }else response=false;
            }else response=false;
        }else response=false;

        return new AnagramResponseDTO(response);
    }

    public String sort(String word){
        char[] arr = word.toLowerCase().toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}
