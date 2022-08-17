package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramResponseDTO;

public interface AnagramService {

    public AnagramResponseDTO isAnagram(String string1, String string2);
}
