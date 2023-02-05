package org.chudnovskiy;

import org.chudnovskiy.util.EmployerHelper;
import org.chudnovskiy.util.PaymentType;

import java.math.BigDecimal;

public class TaxableEmployer extends Employer {
    private final BigDecimal toPay;
    private boolean haveChildren;

    public TaxableEmployer(String name, PaymentType paymentType, BigDecimal sum, boolean haveChildren) {
        super(name, paymentType, sum);
        this.haveChildren = haveChildren;
        this.toPay = getToPay(paymentType, sum);
    }

    private BigDecimal getToPay(PaymentType paymentType, BigDecimal sum) {
        double percent = haveChildren ? (paymentType.percent + 5d) : paymentType.percent;
        return BigDecimal.valueOf(sum.doubleValue() * (100 - percent) / 100);
    }

    public BigDecimal getToPay() {
        return toPay;
    }

    @Override
    public String toString() {
        String string = super.toString();
        if (haveChildren) {
            StringBuilder stringBuilder = new StringBuilder(3);
            for (int i = 0; i < string.length(); i++) {
                if (Character.isDigit(string.charAt(i)))
                    stringBuilder.append(string.charAt(i));
                if (stringBuilder.length() == 2) {
                    break;
                }
            }
            string = super.toString().replace(stringBuilder.toString(), String.valueOf(this.getPaymentType().percent + 5));
        }
        return string + EmployerHelper.currencyFormat(toPay) + "\n";
    }
}
