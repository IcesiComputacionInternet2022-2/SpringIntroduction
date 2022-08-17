package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.dto.ConcatenatedResponseDTO;

import java.util.List;

public interface AnagramService {


    public AnagramResponseDTO isAnagram(List<String> stringList);

}
