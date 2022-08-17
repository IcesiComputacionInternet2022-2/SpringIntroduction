package com.icesi.demo.service;

import com.icesi.demo.dto.AnagramaDTO;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;


@SpringBootApplication
@Service
public interface AnagramaService {

    public AnagramaDTO isAnagrama(List<String> list);
}
