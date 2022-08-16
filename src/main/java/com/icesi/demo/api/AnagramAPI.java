package com.icesi.demo.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AnagramAPI {
    @PostMapping("/isAnagram")
    boolean checkAnagram(@RequestBody List<String> stringList);

}
