package com.icesi.demo.service.implementation;

import com.icesi.demo.service.AnagramService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class AnagramServiceImpl implements AnagramService {

    @Override
    public boolean checkIfAnagram(List<String> stringList) {
        stringList.removeIf(Objects::isNull); //Take nulls away
        stringList.removeIf(s -> Pattern.matches("[0-9]", s)); //Take nums away
        if (stringList.size() != 2) return false;
        char[] chars1 = stringList.get(0).toLowerCase().trim().toCharArray();
        char[] chars2 = stringList.get(1).toLowerCase().trim().toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }
}
