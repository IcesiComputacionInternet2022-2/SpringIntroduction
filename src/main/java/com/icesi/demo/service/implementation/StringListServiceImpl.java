package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.StringListService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StringListServiceImpl implements StringListService {

    @Override
    public ConcatenatedResponseDTO concatenateStrings(List<String> stringList) {
        String a1 = stringList == null || stringList.get(0) == null ? null : stringList.get(0).toLowerCase();
        String a2 = stringList == null || stringList.get(0) == null ? null : stringList.get(1).toLowerCase();
        if(a1 == null || a2 == null){
            return new ConcatenatedResponseDTO(String.valueOf(false));
        } else {
            boolean length = a1.length() == a2.length(), letter = true;
            for (int i = 0; i < a1.length() && length && letter; i++) {
                letter = Character.isLetter(a1.charAt(i));
                a2 = a2.contains(String.valueOf(a1.charAt(i))) ? a2.replaceFirst(String.valueOf(a1.charAt(i)), "") : a2;
            }
            return new ConcatenatedResponseDTO(String.valueOf(a2.equals("") && length && letter));
        }
    }
}
