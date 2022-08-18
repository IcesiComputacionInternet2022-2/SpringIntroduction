package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.StringListService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StringListServiceImpl implements StringListService {

    @Override
    public ConcatenatedResponseDTO concatenateStrings(List<String> stringList) {
        return new ConcatenatedResponseDTO(String.join("", stringList).replace("null", ""));
    }
}
