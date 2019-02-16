package com.ladiesfirst.butterflyBuissnes.cardValidator.cardBrands.imp;

import com.ladiesfirst.butterflyBuissnes.cardValidator.cardBrands.abstraction.CreditCard;

import java.util.Arrays;
import java.util.List;

public class AmericanExpress extends CreditCard {

    private List<String> validPrefixes = Arrays.asList("34", "37");

    @Override
    protected boolean validCardNumberLength(String cardNumber) {
        Integer length = cardNumber.length();
        return length.equals(15);
    }

    @Override
    protected boolean validCardNumberPrefix(String cardNumber) {
        String prefix = cardNumber.substring(0, 2);
        return validPrefixes.contains(prefix);
    }

    @Override
    public String cardType() {
        return "AMERICAN EXPRESS";
    }

}
