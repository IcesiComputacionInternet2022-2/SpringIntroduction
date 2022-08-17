package com.icesi.demo.service.implementation;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import com.icesi.demo.dto.AnagramaResponseDTO;
import com.icesi.demo.service.AnagramaStringServices;
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class AnagramaStringServicesImpl implements AnagramaStringServices {

    @Override
    public AnagramaResponseDTO anagramaStrings(List<String> stringList) {
        String a = stringList.get(0).trim().toLowerCase();
        String b = stringList.get(1).trim().toLowerCase();
        char[] pharseA = a.toCharArray();
        char[] pharseB = b.toCharArray();
        boolean output = true;
        if(pharseA.length == pharseB.length){
            Arrays.sort(pharseA);
            System.out.println(pharseA);
            Arrays.sort(pharseB);
            System.out.println(pharseA);
            if(pharseA.equals(pharseB)){
                output = true;
            }
            System.out.println(output);
        }
        return new AnagramaResponseDTO(output);

//        for(int i = 0; i<b.length();i++){
//            pharseBArrayList.add(b.charAt(i));
//        }
//
//       boolean salida = false;
//        if(a.length() != b.length()){
//            salida = false;
//
//        } else {
//            boolean isFound = true;
//            for(int i=0;i<pharseA.length;i++){
//                for(int j = 0; j < pharseBArrayList.size(); j++)
//                {
//
//                }
//            }
//
//        }
//        return null;

    }
}

