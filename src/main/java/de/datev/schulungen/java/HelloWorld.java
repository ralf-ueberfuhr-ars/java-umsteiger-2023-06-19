package de.datev.schulungen.java;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World");

        // Primitive Datentypen
        // -> Kleinschreibung / Schlüsselwörter, abgeschlossen, keine Objekte

        int i = 4; // 32-bit, byte -> short -> int -> long
        i = 235_324_534;
        i = 0x0061; // 97
        i = 0b01_110; // binär
        i = 0061; // oktal = 49 (dez)

        long l = 4; // (int)4 -> (long)4
        l = 4L;

        double d = 4.0; // 64-bit
        float f = 4.0F; // 32-bit

        boolean b = true;

        char c = 'a';
        c = '\t';
        c = '\n';
        c = '\\';
        c = '\'';
        c = '\u0061';
        int ci = c; // 0061 == 97
        System.out.println(ci);

        // Referenztypen
        // -> CamelCase, erweiterbar (Klassen, ...), Objekte
        String text = "text";
        // Arrays sind Referenztypen
        int[] zahlen = { 3, 5, 7, 3, 2 };
        zahlen[0] = 4; // { 4,5,7,3,2 }

        Boolean b2 = true; // Wertebereich: true, false, null
        Integer i2 = 5;

        // Auto(un)boxing
        i2 = Integer.valueOf(5);
        int i3 = i2; // i2.intValue();

        //i2 = null;
        i3 = i2 == null ? 0 : i2; // ???


    }

}
