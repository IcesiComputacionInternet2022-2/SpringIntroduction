package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramaResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AnagramaStringServices {
    public AnagramaResponseDTO anagramaStrings(List<String>stringList);

}
