package org.chudnovskiy.util;

import org.chudnovskiy.Employer;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployerHelperTest {
    private static final List<Employer> employers = new ArrayList<>(10);

    @Test
    public void whenSumIs9300() {
        employers.add(new Employer("Иванов", PaymentType.BID, new BigDecimal(3000)));
        employers.add(new Employer("Сидоров", PaymentType.PIECE_WORK, new BigDecimal(800)));
        employers.add(new Employer("Иванов", PaymentType.HOURLY, new BigDecimal(5500)));
        assertEquals(new BigDecimal(9300), EmployerHelper.getSum(EmployerHelperTest.employers));
    }
}