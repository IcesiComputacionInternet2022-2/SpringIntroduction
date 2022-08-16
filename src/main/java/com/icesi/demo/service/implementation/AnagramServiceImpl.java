package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AnagramServiceImpl implements AnagramService {

    @Override
    public AnagramResponseDTO anagramResult(List<String> anagramList) {
        char[] first = anagramList.get(0).toString().toLowerCase().toCharArray();
        char[] second = anagramList.get(1).toString().toLowerCase().toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return new AnagramResponseDTO(Arrays.equals(first, second));
    }
}
