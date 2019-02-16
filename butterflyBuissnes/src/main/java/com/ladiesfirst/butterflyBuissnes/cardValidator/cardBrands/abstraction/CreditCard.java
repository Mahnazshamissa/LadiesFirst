package com.ladiesfirst.butterflyBuissnes.cardValidator.cardBrands.abstraction;

public abstract class CreditCard {

    public boolean checkIfCardNumberIsValidvalidate(Long cardNumber) {
        String cardNumberStr = cardNumber.toString();
        return validCardNumberLength(cardNumberStr) && validCardNumberPrefix(cardNumberStr);
    }

    protected abstract boolean validCardNumberLength(String cardNumber);

    protected abstract boolean validCardNumberPrefix(String cardNumber);

    public abstract String cardType();

}
