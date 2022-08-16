package com.icesi.demo.controller;

import com.icesi.demo.api.StringListAPI;
import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.StringListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
public class StringListController implements StringListAPI {

<<<<<<< Updated upstream
=======
    private final StringListService stringListService;
>>>>>>> Stashed changes

    @Override
    public ConcatenatedResponseDTO concatenateStrings(List<String> stringList) {
        return stringListService.concatenateStrings(stringList);
    }

}
