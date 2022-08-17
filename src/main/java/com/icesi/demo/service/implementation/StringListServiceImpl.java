package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.StringListService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StringListServiceImpl implements StringListService {

    @Override
    public ConcatenatedResponseDTO concatenateStrings(List<String> stringList) {
        String concatenatedResponse = "";
        for(String str : stringList)
            if(str.matches("[a-zA-Z]+"))
                concatenatedResponse += str;
        return new ConcatenatedResponseDTO(concatenatedResponse);
    }
}
