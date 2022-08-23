package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramDTO;
import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.AnagramService;
import com.icesi.demo.service.StringListService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.reflect.Array.*;
import static java.util.Arrays.sort;

@Service
public class AnagramServiceImpl implements AnagramService {

    @Override
    public AnagramDTO anagramTwoWords(List<String> stringList) {
        char[] a = stringList.get(0).toCharArray();
        char[] b = stringList.get(1).toCharArray();
        sort(a);
        sort(b);
        boolean theTrue = true;
        if(a.length!=b.length) {
            theTrue=false;
        } else {
            for (int i = 0; i < a.length-1; i++) {
               if(Character.toLowerCase(a[i]) != Character.toLowerCase(b[i])){
                   theTrue=false;
                   i= a.length;
               }
            }
        }
        return new AnagramDTO(theTrue);
    }
}
