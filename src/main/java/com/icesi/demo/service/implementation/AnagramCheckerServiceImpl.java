package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramCheckerResponseDTO;
import com.icesi.demo.service.AnagramCheckerService;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class AnagramCheckerServiceImpl implements AnagramCheckerService {

    @Override
    public AnagramCheckerResponseDTO checkAnagram(List<String> stringList) {
        if(stringList.size() != 2 || stringList.contains(null))
            return new AnagramCheckerResponseDTO(false);
        if(stringList.get(0).length() != stringList.get(1).length())
            return new AnagramCheckerResponseDTO(false);
        for(int i = 0; i < stringList.size(); i ++) {
            char[] temp = stringList.get(i).toCharArray();
            Arrays.sort(temp);
            stringList.remove(i);
            stringList.add(i, new String(temp));
        }
        return new AnagramCheckerResponseDTO(stringList.get(0).equalsIgnoreCase(stringList.get(1)));
    }

}
