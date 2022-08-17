package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramDTO;
import org.springframework.stereotype.Service;

@Service
public interface AnagramService {

    public String order(String s1);
    public AnagramDTO isAnagram(String s1, String s2);

}
