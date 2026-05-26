package com.example.demo.service;

import com.example.demo.dto.BfhlRequest;
import com.example.demo.dto.BfhlResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    @Override
    public BfhlResponse processData(BfhlRequest request) {

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();

        StringBuilder alphabetBuilder = new StringBuilder();

        int sum = 0;

        for (String item : request.getData()) {

            if (item.matches("\\d+")) {

                int number = Integer.parseInt(item);

                sum += number;

                if (number % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }

            } else if (item.matches("[a-zA-Z]+")) {

                alphabets.add(item.toUpperCase());

                alphabetBuilder.append(item);

            } else {

                specialCharacters.add(item);
            }
        }

        String concatString = buildConcatString(alphabetBuilder.toString());

        BfhlResponse response = new BfhlResponse();

        response.setIs_success(true);

        response.setUser_id("neeraj_bhilala_26052026");

        response.setEmail("neeraj@gmail.com");

        response.setRoll_number("REG12345");

        response.setOdd_numbers(oddNumbers);

        response.setEven_numbers(evenNumbers);

        response.setAlphabets(alphabets);

        response.setSpecial_characters(specialCharacters);

        response.setSum(String.valueOf(sum));

        response.setConcat_string(concatString);

        return response;
    }

    private String buildConcatString(String input) {

        String reversed =
                new StringBuilder(input).reverse().toString();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < reversed.length(); i++) {

            char ch = reversed.charAt(i);

            if (i % 2 == 0) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(Character.toLowerCase(ch));
            }
        }

        return result.toString();
    }
}