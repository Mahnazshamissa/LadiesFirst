package com.ladiesfirst.butterflyBuissnes.cardValidator.luhnAlgorithum;

import java.util.stream.IntStream;

public class LuhnAlgorithmus {

    public Boolean verifyLegitimatcy(String cardNo) {
        String reversedString = new StringBuilder().append(cardNo).reverse().toString();

        int sum1 = IntStream.range(0, reversedString.length())
                .boxed()
                .filter(i -> i % 2 != 0)
                .map(index -> getCharAsStringByIndex(reversedString, index))
                .map(Integer::parseInt)
                .map(i -> i * 2)
                .map(this::getSumOfMultipliingByTwo)
                .mapToInt(i -> i)
                .sum();

        int sum2 = IntStream.range(0, reversedString.length())
                .boxed()
                .filter(i -> i % 2 == 0)
                .map(index -> getCharAsStringByIndex(reversedString, index))
                .mapToInt(Integer::parseInt)
                .sum();

        Integer rest = (sum1 + sum2) % 10;

        return rest.equals(0);
    }

    private String getCharAsStringByIndex(String reversedString, int i) {
        return String.valueOf(reversedString.charAt(i));
    }

    private Integer getSumOfMultipliingByTwo(Integer input) {
        String inputAsString = String.valueOf(input);

        return IntStream.range(0, inputAsString.length())
                .boxed()
                .map(index -> getCharAsStringByIndex(inputAsString, index))
                .map(Integer::parseInt)
                .mapToInt(i -> i)
                .sum();
    }

}
