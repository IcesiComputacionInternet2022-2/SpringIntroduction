package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BooleanResultService {

    public AnagramResponseDTO anagramComparator(List<String> list);
}
