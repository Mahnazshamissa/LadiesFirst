package com.ladiesfirst.butterflyBuissnes.cardValidator;

import com.ladiesfirst.butterflyBuissnes.cardValidator.cardBrands.abstraction.CreditCard;
import com.ladiesfirst.butterflyBuissnes.cardValidator.cardBrands.imp.AmericanExpress;
import com.ladiesfirst.butterflyBuissnes.cardValidator.cardBrands.imp.MasterCard;
import com.ladiesfirst.butterflyBuissnes.cardValidator.cardBrands.imp.Visa;
import com.ladiesfirst.butterflyBuissnes.cardValidator.luhnAlgorithum.LuhnAlgorithmus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CreditCardIdentifier {

    private final LuhnAlgorithmus luhnAlgorithmus;

    private String INVALID_CARD_NUMBER = "INVALID";

    private List<CreditCard> creditCardList = Arrays.asList(new AmericanExpress(),
            new MasterCard(), new Visa());

    public String identify(Long cardNumber) {
        String cardNumberStr = cardNumber.toString();
        Boolean legitimateCardNumber = luhnAlgorithmus.verifyLegitimatcy(cardNumberStr);

        if (!legitimateCardNumber) {
            return INVALID_CARD_NUMBER;
        }

        Optional<String> cardNumberResult = creditCardList.stream()
                .map(creditCard -> creditCard.validate(cardNumber))
                .filter(result -> !result.equals(INVALID_CARD_NUMBER))
                .findFirst();

        return cardNumberResult.orElse(INVALID_CARD_NUMBER);
    }

}
