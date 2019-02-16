package com.ladiesfirst.butterflyBuissnes.cardValidator.cardBrands.imp;

import com.ladiesfirst.butterflyBuissnes.cardValidator.cardBrands.abstraction.CreditCard;

import java.util.Arrays;
import java.util.List;

public class MasterCard extends CreditCard {

    private List<String> validPrefixes = Arrays.asList("51", "52", "53", "54", "55");

    @Override
    protected boolean validCardNumberLength(String cardNumber) {
        Integer length = cardNumber.length();
        return length.equals(16);
    }

    @Override
    protected boolean validCardNumberPrefix(String cardNumber) {
        String prefix = cardNumber.substring(0, 2);
        return validPrefixes.contains(prefix);
    }

    @Override
    public String cardType() {
        return "MASTERCARD";
    }

}
