package com.icesi.demo.api;

import com.icesi.demo.dto.ConcatenatedResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface AnagramApi {

    @PostMapping("/anagrams")
    public ConcatenatedResponseDTO concatenateStrings(@RequestBody List<String> stringList);

}
