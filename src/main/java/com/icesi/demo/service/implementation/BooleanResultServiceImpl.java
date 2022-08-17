package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.BooleanResultService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BooleanResultServiceImpl implements BooleanResultService {
    @Override
    public AnagramResponseDTO anagramComparator(List<String> list){
        Boolean answer = false;
        if (list.get(0).length() != list.get(1).length()) {
            answer = false;
        }
        String a = list.get(0).toLowerCase();
        String b = list.get(1).toLowerCase();
        char[] candidate1 = a.toCharArray();
        char[] candidate2 = b.toCharArray();
        Arrays.sort(candidate1);
        Arrays.sort(candidate2);
        answer = Arrays.equals(candidate1, candidate2);
        return new AnagramResponseDTO(answer);
    }
}
