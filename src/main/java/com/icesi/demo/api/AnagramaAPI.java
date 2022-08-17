package com.icesi.demo.api;

import com.icesi.demo.dto.AnagramaDTO;
import com.icesi.demo.service.AnagramaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public interface AnagramaAPI {

    @PostMapping("/anagrama")
    public AnagramaDTO areAnagrama(@RequestBody List<String> list);

    @GetMapping("/aloh")
    public String getStatus();

}
