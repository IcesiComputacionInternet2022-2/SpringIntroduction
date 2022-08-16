package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.dto.ConcatenatedResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StringListService {


    public ConcatenatedResponseDTO concatenateStrings(List<String> stringList);

    public AnagramResponseDTO searchAnagram(List<String> stringList);
}
