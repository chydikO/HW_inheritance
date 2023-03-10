package org.chudnovskiy.util;

import org.chudnovskiy.Employer;
import org.chudnovskiy.TaxableEmployer;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployerHelperTest {

    @Test
    public void whenSumIs9300() {
        List<Employer> employers = new ArrayList<>(10);
        employers.add(new Employer("Иванов", PaymentType.BID, new BigDecimal(3000)));
        employers.add(new Employer("Сидоров", PaymentType.PIECE_WORK, new BigDecimal(800)));
        employers.add(new Employer("Иванов", PaymentType.HOURLY, new BigDecimal(5500)));
        assertEquals(
                EmployerHelper.currencyFormat(new BigDecimal(9300)),
                EmployerHelper.currencyFormat(EmployerHelper.getSum(employers))
        );
    }

    @Test
    public void whenPayIs7290() {
        List<Employer> employers = new ArrayList<>(10);
        employers.add(new TaxableEmployer("Иванов", PaymentType.BID, new BigDecimal(3000), true));
        employers.add(new TaxableEmployer("Сидоров", PaymentType.HOURLY, new BigDecimal(800), false));
        employers.add(new TaxableEmployer("Иванова", PaymentType.PIECE_WORK, new BigDecimal(5500), true));
        assertEquals(
                EmployerHelper.currencyFormat(new BigDecimal(7290)),
                EmployerHelper.currencyFormat(EmployerHelper.getToPay(employers))
        );
    }
}