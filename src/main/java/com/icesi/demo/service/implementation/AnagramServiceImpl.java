package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class AnagramServiceImpl implements AnagramService {

    @Override
    public AnagramResponseDTO isAnagram(String string1, String string2) {
        return new AnagramResponseDTO(Arrays.equals(string1.toLowerCase().codePoints().sorted().toArray(), string2.toLowerCase().codePoints().sorted().toArray()));
    }
}
