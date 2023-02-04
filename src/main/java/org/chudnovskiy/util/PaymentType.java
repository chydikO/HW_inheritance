package org.chudnovskiy.util;

public enum PaymentType {
    BID("ставка", 20),
    HOURLY("почасовая", 20),
    PIECE_WORK("сдельная", 15);

    public final String label;
    public final int percent;


    PaymentType(String label, int percent) {
        this.label = label;
        this.percent = percent;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
