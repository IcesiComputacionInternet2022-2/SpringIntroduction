package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramResponseDTO;

import java.util.List;

public interface AnagramService {
    public AnagramResponseDTO anagramString(List<String> words);
}
