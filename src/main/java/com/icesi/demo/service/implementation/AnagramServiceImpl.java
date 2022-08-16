package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.ConfirmationDTO;
import com.icesi.demo.service.AnagramService;

import java.util.List;
import java.util.Objects;


public class AnagramServiceImpl implements AnagramService {

    @Override
    public ConfirmationDTO checkAnagrams(List<String> stringList) {
        stringList.removeIf(Objects::isNull);
        return new ConfirmationDTO(true);
    }
}
