package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramResponseDTO;

import java.util.List;

public interface AnagramListService {

    public AnagramResponseDTO isAnagram(List<String> strings);

}
