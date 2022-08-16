package com.icesi.demo.service;

import com.icesi.demo.dto.ConfirmationDTO;

import java.util.List;

public interface AnagramService {

    public ConfirmationDTO checkAnagrams(List<String> stringList);
}
