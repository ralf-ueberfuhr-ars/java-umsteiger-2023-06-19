package de.datev.schulungen.java.firma;

public class Start {

    public static void main(String[] args) {
        Konto konto = new Konto("123");
        konto.setStand(1234_56);

        Konto konto2 = new Konto("234");
        System.out.println(konto);

        konto2.einzahlen(5);
        try {
            konto2.abheben(100);
        } catch (KontoNichtGedecktException e) {
            e.printStackTrace();
            System.err.println(e.getBetrag());
        }

    }

}
