package de.datev.schulungen.java.firma;

import java.util.Objects;

public class Konto {

    private final String iban;
    private long stand; // in Cent // float: ungenau! // BigDecimal

    public Konto(String iban) {
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    public long getStand() {
        return stand;
    }

    public void setStand(long stand) {
        this.stand = stand;
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
