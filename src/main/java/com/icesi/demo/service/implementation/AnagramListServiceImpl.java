package com.icesi.demo.service.implementation;


import com.icesi.demo.dto.AnagramResponseDTO;
import com.icesi.demo.service.AnagramListService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AnagramListServiceImpl implements AnagramListService {

    @Override
    public AnagramResponseDTO isAnagram(List<String> stringList) {
        Boolean isAnagram = false;

        try {
            int firstWordSize = stringList.get(0).length();
            int secondWordSize = stringList.get(1).length();

            if(stringList.size()>2){
                isAnagram = false;
            }else if (firstWordSize != secondWordSize) {
                isAnagram = false;
            }else{
                String firstWord = stringList.get(0).toLowerCase();
                String secondWord = stringList.get(1).toLowerCase();
                //convertimos las palabras en arreglo de chars
                char[] lettersFirstWord = firstWord.toCharArray();
                char[] lettersSecondWord = secondWord.toCharArray();

                //Ordenamos las letras
                Arrays.sort(lettersFirstWord);
                Arrays.sort(lettersSecondWord);

                //verificamos que los arreglos ordenados sean identicos.
                isAnagram = Arrays.equals(lettersFirstWord, lettersSecondWord);


            }
        }catch (Exception e){
            isAnagram=false;
        }


        return new AnagramResponseDTO(isAnagram);

    }

}