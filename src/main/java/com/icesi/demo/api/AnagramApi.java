package com.icesi.demo.api;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.icesi.demo.dto.AnagramResponseDTO;

public interface AnagramApi {
	
    @PostMapping("/anagrama")
    public AnagramResponseDTO isAnagram(@RequestBody List<String> myList); 
    
}
