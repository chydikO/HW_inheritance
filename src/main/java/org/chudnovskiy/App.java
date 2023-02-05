package org.chudnovskiy;

import org.chudnovskiy.util.EmployerHelper;
import org.chudnovskiy.util.PaymentType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final List<Employer> employers = new ArrayList<>(10);

    public static void main(String[] args) {
        loadDataToEmployers();
        EmployerHelper.drawTable(employers);

        TaxableEmployer taxableEmployer = new TaxableEmployer("Иванов", PaymentType.BID, new BigDecimal(3000));
        //System.out.println(taxableEmployer);

    }

    private static void loadDataToEmployers() {
        employers.add(new TaxableEmployer("Иванов", PaymentType.BID, new BigDecimal(3000)));
        employers.add(new TaxableEmployer("Сидоров", PaymentType.HOURLY, new BigDecimal(800)));
        employers.add(new TaxableEmployer("Иванов", PaymentType.PIECE_WORK, new BigDecimal(5500)));
    }


}
