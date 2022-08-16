package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramDTO;
import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.AnagramService;
import com.icesi.demo.service.StringListService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnagramServiceImpl implements AnagramService {

    @Override
    public AnagramDTO anagramTwoWords(String a1,String a2) {
        char[] string1 = a1.toCharArray();
        char[] string2 = a2.toCharArray();
        return new AnagramDTO(a1 == a2);
    }
}
