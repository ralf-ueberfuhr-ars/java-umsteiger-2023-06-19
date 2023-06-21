package de.datev.schulungen.java.firma;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Stream;

public class Firma {

    private final Collection<Mitarbeiter> mitarbeiter = new HashSet<>();
    private String name;
    private String sitz;

    private Konto konto;

    public Firma(String name, String sitz, Konto konto) {
        this.name = name;
        this.sitz = sitz;
        this.konto = konto;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }


    public Collection<Mitarbeiter> getMitarbeiter() {
        return Collections.unmodifiableCollection(mitarbeiter);
    }
    public Stream<Mitarbeiter> getMitarbeiter2() {
        return this.mitarbeiter.stream();
    }

    public void einstellen(Mitarbeiter mitarbeiter) {
        this.mitarbeiter.add(mitarbeiter);
    }

    public void entlassen(Mitarbeiter mitarbeiter) {
        this.mitarbeiter.remove(mitarbeiter);
    }

    private void gehaltZahlen(Mitarbeiter mitarbeiter) {
        // Gehalt ermitteln
        var gehalt = mitarbeiter.getGehalt();
        // Gehalt vom Konto der Firma abziehen
        this.konto.abheben(gehalt);
        // Gehalt auf das Konto des Mitarbeiters überweisen
        mitarbeiter.getKonto().einzahlen(gehalt);
    }

    public void gehaltZahlen() {
        for(Mitarbeiter m : this.mitarbeiter) {
            gehaltZahlen(m);
        }
    }

    public Mitarbeiter getTeuersterMitarbeiter() {
        Mitarbeiter result = null;
        for(Mitarbeiter m : this.mitarbeiter) {
            if(result == null || m.getGehalt() > result.getGehalt()) {
                result = m;
            }
        }
        return result;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSitz() {
        return sitz;
    }

    public void setSitz(String sitz) {
        this.sitz = sitz;
    }
}
