package org.chudnovskiy.util;

import org.chudnovskiy.Employer;
import org.chudnovskiy.TaxableEmployer;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

public class EmployerHelper {
    static public BigDecimal getSum(List<Employer> employers) {
        BigDecimal sum = new BigDecimal(0);
        for (Employer employer : employers) {
            sum = sum.add(employer.getSum());
        }
        return sum;
    }

    static public void drawTable(List<Employer> employers) {
        System.out.printf("%-15s%-10s%-15s%-15s%n", "ФИО", "Налог", "Сумма", "К оплате");
        for (Employer employer : employers) {
            System.out.print(employer);
        }
        System.out.printf("\n%-25s%-15s%-15s%n", "Итого", currencyFormat(getSum(employers)), currencyFormat(getToPay(employers)));
    }

    private static BigDecimal getToPay(List<Employer> employers) {
        BigDecimal sum = new BigDecimal(0);
        for (Employer employer : employers) {
            if (employer instanceof TaxableEmployer) {
                sum = sum.add(((TaxableEmployer) employer).getToPay());
            }
        }
        return sum;
    }

    public static String currencyFormat(BigDecimal n) {
        return NumberFormat.getCurrencyInstance().format(n);
    }
}
