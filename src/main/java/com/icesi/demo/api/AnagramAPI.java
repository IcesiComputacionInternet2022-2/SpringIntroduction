package com.icesi.demo.api;

import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.dto.ConcatenatedResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AnagramAPI {

    @PostMapping("/findAnagram")
    public AnagramResponseDTO findAnagram(@RequestBody String str1, String str2);
}
