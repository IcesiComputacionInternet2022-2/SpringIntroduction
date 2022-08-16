package com.icesi.demo.api;

import com.icesi.demo.dto.AnagramResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public interface AnagramListAPI {

    @PostMapping("/anagram")
    public AnagramResponseDTO searchAnagram(@RequestBody List<String> stringList);

}
