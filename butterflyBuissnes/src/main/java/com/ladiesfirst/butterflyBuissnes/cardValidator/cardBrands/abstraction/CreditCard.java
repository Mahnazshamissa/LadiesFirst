package com.ladiesfirst.butterflyBuissnes.cardValidator.cardBrands.abstraction;

public abstract class CreditCard {

    public String validate(Long cardNumber) {
        String cardNumberStr = cardNumber.toString();
        if (validCardNumberLength(cardNumberStr) && validCardNumberPrefix(cardNumberStr)) {
            return cardType();
        }
        return "INVALID";
    }

    protected abstract boolean validCardNumberLength(String cardNumber);

    protected abstract boolean validCardNumberPrefix(String cardNumber);

    public abstract String cardType();

}
