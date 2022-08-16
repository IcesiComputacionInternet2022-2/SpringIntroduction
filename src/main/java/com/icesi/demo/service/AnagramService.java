package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AnagramService {
    public AnagramResponseDTO searchAnagram(List<String> stringList);
}
