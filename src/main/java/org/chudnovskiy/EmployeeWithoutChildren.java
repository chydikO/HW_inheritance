package org.chudnovskiy;

import org.chudnovskiy.util.PaymentType;

import java.math.BigDecimal;

public class EmployeeWithoutChildren extends TaxableEmployer {
    private int tax;
    public EmployeeWithoutChildren(String name, PaymentType paymentType, BigDecimal sum) {
        super(name, paymentType, sum);

    }
}
