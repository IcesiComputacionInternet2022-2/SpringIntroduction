package com.icesi.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.icesi.demo.api.AnagramApi;
import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;

@RestController
public class AnagramController implements AnagramApi {
	
private final AnagramService anagramService;
	
	
	public AnagramController(AnagramService anagramService) {
		this.anagramService = anagramService;
	}
	
	@Override
	public AnagramResponseDTO isAnagram(List<String> myList) {
        return anagramService.isAnagram(myList);
	}

}
