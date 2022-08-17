package com.icesi.demo.api;

import com.icesi.demo.dto.AnagramResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AnagramApi {
    @PostMapping("/anagramStrings")
    public AnagramResponseDTO anagramString(@RequestBody List<String> words);

}