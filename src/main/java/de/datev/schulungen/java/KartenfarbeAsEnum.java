package de.datev.schulungen.java;

import lombok.Getter;

public enum KartenfarbeAsEnum /* extends Enum<KartenfarbeAsEnum> */ {

    /*
     * - KARO = 9, HERZ = 10, PIK = 11, KREUZ = 12;
     */

    KARO(9),
    HERZ(10),
    PIK(11),
    KREUZ(12);

    @Getter
    private final int wert;

    // @RequiredArgsConstructor(...PRIVATE)
    KartenfarbeAsEnum(int wert) {
        this.wert = wert;
    }

    public static void main(String[] args) {
        KartenfarbeAsEnum k1 = KartenfarbeAsEnum.HERZ;
        int wertVonPil = KartenfarbeAsEnum.PIK.getWert();
        // enum -> switch case
        switch (k1) {
        case PIK: break;
        case HERZ: break;
        }
        // extends Enum
        k1.ordinal(); // 0, 1, 2, 3
        for(KartenfarbeAsEnum k : KartenfarbeAsEnum.values()) {

        }
    }


}
