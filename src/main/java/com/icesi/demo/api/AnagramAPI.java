package com.icesi.demo.api;

import com.icesi.demo.dto.AnagramResponseDTO;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AnagramAPI {

    @PostMapping("/isAnagram")
    public AnagramResponseDTO isAnagram(@RequestBody List<String> strings);

}
