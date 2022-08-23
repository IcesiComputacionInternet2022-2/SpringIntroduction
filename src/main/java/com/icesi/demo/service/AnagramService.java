package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramDTO;
import com.icesi.demo.dto.ConcatenatedResponseDTO;

import java.util.List;

public interface AnagramService {


    public AnagramDTO anagramTwoWords(List<String> stringList);

}
