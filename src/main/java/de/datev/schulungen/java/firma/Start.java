package de.datev.schulungen.java.firma;

import de.datev.schulungen.java.scheduler.SchedulingFramework;

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


        Firma firma = new Firma("ACME", "Nürnberg", konto);
        SchedulingFramework framework = new SchedulingFramework();
        framework.handle(firma);

        Mitarbeiter tom = new Mitarbeiter("Tom", 3000, konto2, MitarbeiterRolle.AUSZUBILDENDER);
        framework.handle(tom);

        int höchsteGehalt = firma.getTeuersterMitarbeiter()
          .map(Mitarbeiter::getGehalt)
          .orElse(0);

    }

}
