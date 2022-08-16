package com.icesi.demo.api;

import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.dto.WordDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AnagramaAPI {

    @PostMapping("/anagrama")
    public WordDTO WordDTO(@RequestBody List<String> stringList);

}
