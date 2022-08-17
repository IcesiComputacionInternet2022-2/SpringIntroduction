package com.icesi.demo.service;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.icesi.demo.dto.AnagramResponseDTO;

@Service
@SpringBootApplication
public interface AnagramService {
	public AnagramResponseDTO isAnagram(List<String> myList); //Lista
}
