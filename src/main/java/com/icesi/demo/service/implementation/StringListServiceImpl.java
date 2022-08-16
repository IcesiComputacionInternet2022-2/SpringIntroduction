package com.icesi.demo.service.implementation;

import com.icesi.demo.dto.ConcatenatedResponseDTO;
import com.icesi.demo.service.StringListService;
import com.sun.org.apache.xerces.internal.xs.StringList;
import com.sun.org.apache.xpath.internal.operations.String;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StringListServiceImpl implements StringListService {

    @Override
    public ConcatenatedResponseDTO concatenateStrings(List<java.lang.String> stringList) {
        return new ConcatenatedResponseDTO(Strings.join(stringList, ' '));
    }
}
