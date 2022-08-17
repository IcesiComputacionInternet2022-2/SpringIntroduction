package com.icesi.demo.service.implementation;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramService;

@Service
public class AnagramServiceImpl implements AnagramService {

	@Override
	public AnagramResponseDTO isAnagram(List<String> myList) {
		String word1 = myList.get(0);
		String word2 = myList.get(1);
		if(word1.length() != word2.length()) {
			return new AnagramResponseDTO(false);
		}else {
			char[] c1 = word1.toCharArray();
			char[] c2 = word2.toCharArray();
			
			Arrays.sort(c1);
			Arrays.sort(c2);
			
			if(Arrays.equals(c1, c2)) {
				return new AnagramResponseDTO(true);
			}
			else {
				return new AnagramResponseDTO(false);
			}
		}
	}

}
