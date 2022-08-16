package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.ConfirmationDTO;
import com.icesi.demo.service.AnagramService;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;


public class AnagramServiceImpl implements AnagramService {

    @Override
    public ConfirmationDTO checkAnagrams(List<String> stringList) {
        stringList.removeIf(Objects::isNull);
        stringList.removeIf(s -> Pattern.matches("[0-9]", s));
        if (stringList.size() > 2) {
            return new ConfirmationDTO(false);
        }

        String element1 = stringList.get(0).toLowerCase();
        String element2 = stringList.get(0).toLowerCase();
        char[] charArray1 = element1.toCharArray();
        char[] charArray2 = element2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        if(Arrays.equals(charArray1, charArray2)){
            return new ConfirmationDTO(true);
        }
        return new ConfirmationDTO(false);

    }
}
