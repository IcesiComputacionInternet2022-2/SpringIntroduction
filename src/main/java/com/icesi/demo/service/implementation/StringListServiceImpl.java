package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.StringListService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class StringListServiceImpl implements StringListService {

    @Override
    public ConcatenatedResponseDTO concatenateStrings(List<String> stringList) {
        String response = "";
        for(String cadena :stringList) {
            if (cadena!=null) response+=cadena;
        }
        return new ConcatenatedResponseDTO(response);
    }
}
