package de.datev.schulungen.java.firma;

import de.datev.schulungen.java.scheduler.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
@Setter
//@Data = Getter/Setter/Hashcode/Equals/
public class Mitarbeiter {

    private String name;
    private int gehalt;
    private Konto konto;
    private MitarbeiterRolle rolle = MitarbeiterRolle.ANGESTELLTER;

    public int getUrlaub() {
        return this.rolle.getUrlaub(); // null?
    }

    @Schedule(value = 2500, unit = TimeUnit.MILLISECONDS)
    public void niesen() {
        System.out.println("Hatschi!");
    }

}
