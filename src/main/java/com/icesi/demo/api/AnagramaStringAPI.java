package com.icesi.demo.api;

import com.icesi.demo.dto.AnagramaResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AnagramaStringAPI {
    @PostMapping("/anagramaStrings")
    public AnagramaResponseDTO angramaStrings(@RequestBody List<String> stringList);
}
