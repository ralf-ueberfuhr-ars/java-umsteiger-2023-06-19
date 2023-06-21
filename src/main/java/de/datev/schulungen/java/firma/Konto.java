package de.datev.schulungen.java.firma;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
public class Konto {

    private final String iban;
    private long stand; // in Cent // float: ungenau! // BigDecimal


    public void einzahlen(long betrag) {
        if(betrag > 0) {
            this.stand += betrag;
        } else {
            throw new IllegalArgumentException("betrag must be gt zero");
        }
    }

    public void abheben(long betrag) throws KontoNichtGedecktException {
        if(betrag > 0) {
            if(this.stand >= betrag) {
                this.stand -= betrag;
            } else {
                throw new KontoNichtGedecktException(this, betrag);
            }
        } else {
            throw new IllegalArgumentException("betrag must be gt zero");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Konto konto = (Konto) o;
        return Objects.equals(iban, konto.iban);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban);
    }

    @Override
    public String toString() {
        return String.format("Konto mit IBAN %s und Stand %d", iban, stand);
//        return "Konto{" +
//          "iban='" + iban + '\'' +
//          ", stand=" + stand +
//          '}';
    }

/*
    {
        // 12.35 EUR
        BigDecimal bd = BigDecimal.valueOf(1235, 2);
        //bd = BigDecimal.valueOf(12.35);
        bd.add(...)
    }
     */

}
