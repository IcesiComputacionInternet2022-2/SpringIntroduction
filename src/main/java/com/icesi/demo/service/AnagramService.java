package com.icesi.demo.service;

import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.dto.IsAnagramResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AnagramService {


    public IsAnagramResponseDTO isAnagram(List<String> words);

}
