package de.datev.schulungen.java.firma;

public class Firma {

    private Mitarbeiter[] mitarbeiter;
    private String name;
    private String sitz;

    public Firma(String name, String sitz) {
        this.name = name;
        this.sitz = sitz;
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
