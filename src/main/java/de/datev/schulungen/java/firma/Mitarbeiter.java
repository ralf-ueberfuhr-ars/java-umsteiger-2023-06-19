package de.datev.schulungen.java.firma;

public class Mitarbeiter {

    private String name;
    private int gehalt;
    private Konto konto;

    public Mitarbeiter(String name, int gehalt, Konto konto) {
        this.name = name;
        this.gehalt = gehalt;
        this.konto = konto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGehalt() {
        return gehalt;
    }

    public void setGehalt(int gehalt) {
        this.gehalt = gehalt;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }
}
