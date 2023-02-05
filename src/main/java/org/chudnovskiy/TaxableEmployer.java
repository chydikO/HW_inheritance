package org.chudnovskiy;

import org.chudnovskiy.util.EmployerHelper;
import org.chudnovskiy.util.PaymentType;

import java.math.BigDecimal;

public class TaxableEmployer extends Employer {
    private final BigDecimal toPay;

    public TaxableEmployer(String name, PaymentType paymentType, BigDecimal sum) {
        super(name, paymentType, sum);
        this.toPay = getToPay(paymentType, sum);
    }

    private BigDecimal getToPay(PaymentType paymentType, BigDecimal sum) {
        return BigDecimal.valueOf(sum.doubleValue() * (100 - (double) (paymentType.percent)) / 100);
    }

    public BigDecimal getToPay() {
        return toPay;
    }

    @Override
    public String toString() {
//        String string = super.toString().replace("\n", "").replace("\r", "");
        return super.toString() + EmployerHelper.currencyFormat(toPay) + "\n";
    }
}
