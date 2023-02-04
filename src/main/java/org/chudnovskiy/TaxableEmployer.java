package org.chudnovskiy;

import org.chudnovskiy.util.PaymentType;

import java.math.BigDecimal;

public class TaxableEmployer extends Employer {
    private BigDecimal toPay;

    public TaxableEmployer(String name, PaymentType paymentType, BigDecimal sum) {
        super(name, paymentType, sum);
        this.toPay = getToPay(paymentType, sum);
    }

    private BigDecimal getToPay(PaymentType paymentType, BigDecimal sum) {
        return new BigDecimal(sum.doubleValue() * (100.d - (double)(paymentType.percent)) / 100.d);
    }
}
