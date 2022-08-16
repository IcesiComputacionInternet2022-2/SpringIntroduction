package com.icesi.demo.api;

import com.icesi.demo.dto.AnagramCheckerResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AnagramCheckerAPI {

    @PostMapping("/checkAnagram")
    public AnagramCheckerResponseDTO checkAnagram(@RequestBody List<String> stringList);


}
