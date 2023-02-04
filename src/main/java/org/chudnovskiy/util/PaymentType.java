package org.chudnovskiy.util;

public enum PaymentType {
    BID("ставка"),
    HOURLY("почасовая"),
    PIECE_WORK("сдельная");

    public final String label;

    PaymentType(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
