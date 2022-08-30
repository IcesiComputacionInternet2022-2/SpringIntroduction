package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.StringListService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StringListServiceImpl implements StringListService {


    @Override
    public ConcatenatedResponseDTO concatenateStrings(List<String> stringList) {
        return new ConcatenatedResponseDTO(stringList.stream().map(str -> str==null?(String)"":str).collect(Collectors.joining("")));
    }
}
