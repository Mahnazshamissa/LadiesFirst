package com.ladiesfirst.butterflyBuissnes.luhnalgorithmus;

import com.ladiesfirst.butterflyBuissnes.cardValidator.luhnAlgorithum.LuhnAlgorithmus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LuhnAlgorithmusTest {

    @Test
    void credit() {
        LuhnAlgorithmus luhnAlgorithmus = new LuhnAlgorithmus();
        Boolean result1 = luhnAlgorithmus.verifyLegitimatcy("378282246310005");
        Boolean result2 = luhnAlgorithmus.verifyLegitimatcy("388282246310005");

        Assertions.assertTrue(result1);
        Assertions.assertFalse(result2);
    }

}
