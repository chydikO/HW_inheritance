package org.chudnovskiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
        return String.format("%-15s%-10s%-15s",
                name, paymentType.percent, EmployerHelper.currencyFormat(sum));
    }
}
