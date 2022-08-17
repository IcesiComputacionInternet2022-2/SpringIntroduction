package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.AnagramService;
import com.icesi.demo.service.StringListService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AnagramListServiceImpl implements AnagramService {

    @Override
    public AnagramResponseDTO findAnagram(String str1, String str2) {

        boolean flag = true;
        for (int i = 0, c = 0; i < str1.length() && c < str2.length() && flag; i++, c++) {
            flag = !Character.isDigit(str1.charAt(i));
            flag = !Character.isDigit(str2.charAt(c));
        }
        if (flag == true){
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            return new AnagramResponseDTO(Arrays.equals(arr1, arr2));
        }else return new AnagramResponseDTO(false);
    }
}
