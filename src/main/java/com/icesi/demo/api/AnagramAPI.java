package com.icesi.demo.api;


import com.icesi.demo.dto.ConfirmationDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AnagramAPI {
    @PostMapping("/checkAnagrams")
    public ConfirmationDTO checkAnagrams(@RequestBody List<String> stringList);
}
