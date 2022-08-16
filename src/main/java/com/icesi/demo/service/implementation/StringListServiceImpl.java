package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.StringListService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class StringListServiceImpl implements StringListService {

    @Override
    public ConcatenatedResponseDTO concatenateStrings(List<String> stringList) {
        return new ConcatenatedResponseDTO(stringList.stream()
                .filter(s -> s != null)
                .collect(Collectors.joining("")));

        //return new ConcatenatedResponseDTO(String.join("", stringList));
    }
}
