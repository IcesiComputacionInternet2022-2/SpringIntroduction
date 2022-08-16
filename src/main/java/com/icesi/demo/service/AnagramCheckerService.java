package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramCheckerResponseDTO;

import java.util.List;

public interface AnagramCheckerService {

    public AnagramCheckerResponseDTO checkAnagram(List<String> stringList);

}
