package org.chudnovskiy;

import org.chudnovskiy.util.EmployerHelper;
import org.chudnovskiy.util.PaymentType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaxableEmployerTest {

    @Test
    void wenPayIs2400() {
        TaxableEmployer taxableEmployer = new TaxableEmployer("Иванов", PaymentType.BID, new BigDecimal(3000), false);
        assertEquals(
                EmployerHelper.currencyFormat(new BigDecimal(2400)),
                EmployerHelper.currencyFormat(taxableEmployer.getToPay())
        );
    }
}