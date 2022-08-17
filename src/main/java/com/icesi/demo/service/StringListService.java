package com.icesi.demo.service;

import com.icesi.demo.dto.ConcatenatedResponseDTO;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootApplication
@Service
public interface StringListService {


    public ConcatenatedResponseDTO concatenateStrings(List<String> stringList);

}
