package com.icesi.demo.api;

import com.icesi.demo.dto.ConcatenatedResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public interface StringListAPI {

    @PostMapping("/concatenateStrings")
    public ConcatenatedResponseDTO concatenateStrings(@RequestBody List<String> stringList);

}
