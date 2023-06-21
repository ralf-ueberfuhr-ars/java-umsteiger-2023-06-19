package de.datev.schulungen.java.firma;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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

}
