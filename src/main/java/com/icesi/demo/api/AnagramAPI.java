package com.icesi.demo.api;

import com.icesi.demo.dto.AnagramDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AnagramAPI {

    @GetMapping("/anagramAPI")
    public AnagramDTO isAnagram(@RequestBody List<String> stringList);
}
