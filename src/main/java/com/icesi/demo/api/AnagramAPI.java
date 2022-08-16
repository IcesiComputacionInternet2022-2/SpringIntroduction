package com.icesi.demo.api;

import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.dto.IsAnagramResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Service
public interface AnagramAPI {

    @PostMapping("/isanagram")
    public IsAnagramResponseDTO isAnagram(@RequestBody List<String> words);

}
