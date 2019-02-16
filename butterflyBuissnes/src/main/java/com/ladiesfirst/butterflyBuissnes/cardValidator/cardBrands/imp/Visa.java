package com.ladiesfirst.butterflyBuissnes.cardValidator.cardBrands.imp;

import com.ladiesfirst.butterflyBuissnes.cardValidator.cardBrands.abstraction.CreditCard;

import java.util.Arrays;
import java.util.List;

public class Visa extends CreditCard {

    private List<String> validPrefixes = Arrays.asList("4");

    @Override
    protected boolean validCardNumberLength(String cardNumber) {
        Integer length = cardNumber.length();
        return length.equals(13) || length.equals(16);
    }

    @Override
    protected boolean validCardNumberPrefix(String cardNumber) {
        String prefix = cardNumber.substring(0, 1);
        return validPrefixes.contains(prefix);
    }

    @Override
    public String cardType() {
        return "VISA";
    }

}
