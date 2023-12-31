package de.datev.schulungen.java.firma;

import de.datev.schulungen.java.scheduler.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
@Setter
public class Firma {

    private final Collection<Mitarbeiter> mitarbeiter = new HashSet<>();
    private String name;
    private String sitz;
    private Konto konto;


    public Collection<Mitarbeiter> getMitarbeiter() {
        return Collections.unmodifiableCollection(mitarbeiter);
    }
    public Stream<Mitarbeiter> getMitarbeiter2() {
        return this.mitarbeiter.stream();
    }

    public void einstellen(Mitarbeiter mitarbeiter) {
        if(null == mitarbeiter) {
            throw new IllegalArgumentException("mitarbeiter must not be null");
        }
        this.mitarbeiter.add(mitarbeiter);
    }

    public void entlassen(Mitarbeiter mitarbeiter) {
        this.mitarbeiter.remove(mitarbeiter);
    }

    private void gehaltZahlen(Mitarbeiter mitarbeiter) throws KontoNichtGedecktException {
        // Gehalt ermitteln
        var gehalt = mitarbeiter.getGehalt();
        // Gehalt vom Konto der Firma abziehen
        this.konto.abheben(gehalt);
        // Gehalt auf das Konto des Mitarbeiters überweisen
        mitarbeiter.getKonto().einzahlen(gehalt);
    }

    @Schedule(1)
    public void gehaltZahlen() throws KontoNichtGedecktException {
        System.out.println("Zahltag!");
        for(Mitarbeiter m : this.mitarbeiter) {
            gehaltZahlen(m);
        }
        // geht nicht, weil Exception compiler-geprüft
        // this.mitarbeiter.forEach(this::gehaltZahlen);
    }

    public Optional<Mitarbeiter> getTeuersterMitarbeiter() {
        Mitarbeiter result = null;
        for(Mitarbeiter m : this.mitarbeiter) {
            if(result == null || m.getGehalt() > result.getGehalt()) {
                result = m;
            }
        }
        return Optional.ofNullable(result);
    }

}
