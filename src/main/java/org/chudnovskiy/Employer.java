package org.chudnovskiy;

import lombok.*;
import org.chudnovskiy.util.EmployerHelper;
import org.chudnovskiy.util.PaymentType;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Employer {
    private String name;
    private PaymentType paymentType;
    private BigDecimal sum;


    @Override
    public String toString() {
        return String.format("%-15s%-15s%-15s%n",
        name, paymentType, EmployerHelper.currencyFormat(sum));
    }
}
