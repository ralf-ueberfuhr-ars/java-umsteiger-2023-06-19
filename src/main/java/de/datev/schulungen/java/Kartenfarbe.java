package de.datev.schulungen.java;

import lombok.Getter;

public class Kartenfarbe {

    /*
     * - KARO = 9, HERZ = 10, PIK = 11, KREUZ = 12;
     */

    public static final Kartenfarbe KARO = new Kartenfarbe(9);
    public static final Kartenfarbe HERZ = new Kartenfarbe(10);
    public static final Kartenfarbe PIK = new Kartenfarbe(11);
    public static final Kartenfarbe KREUZ = new Kartenfarbe(12);

    @Getter
    private final int wert;

    // @RequiredArgsConstructor(...PRIVATE)
    private Kartenfarbe(int wert) {
        this.wert = wert;
    }

    public static void main(String[] args) {
        Kartenfarbe k1 = Kartenfarbe.HERZ;
        int wertVonPil = Kartenfarbe.PIK.getWert();
    }


}
