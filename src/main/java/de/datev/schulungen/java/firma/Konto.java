package de.datev.schulungen.java.firma;

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
