package com.icesi.demo.service;

import com.icesi.demo.dto.ConcatenatedResponseDTO;
import java.util.List;

public interface StringListService {

    public ConcatenatedResponseDTO concatenateStrings(List<String> stringList);
}
