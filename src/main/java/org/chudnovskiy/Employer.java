package org.chudnovskiy;

import lombok.*;
import org.chudnovskiy.util.PaymentType;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Employer {
    private String name;
    private PaymentType paymentType;
    private BigDecimal sum;
}
