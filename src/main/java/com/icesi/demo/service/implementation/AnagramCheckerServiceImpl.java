package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramCheckerResponseDTO;
import com.icesi.demo.service.AnagramCheckerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AnagramCheckerServiceImpl implements AnagramCheckerService {

    @Override
    public AnagramCheckerResponseDTO checkAnagram(List<String> stringList) {
        if(stringList.size() != 2) {
            return null;
        }
        for(int i = 0; i < stringList.size(); i ++) {
            char[] tempArray = stringList.get(i).toCharArray();
            Arrays.sort(tempArray);
            stringList.remove(i);
            stringList.add(i, new String(tempArray));
        }
        return new AnagramCheckerResponseDTO(stringList.get(0).equalsIgnoreCase(stringList.get(1)));
    }

}
