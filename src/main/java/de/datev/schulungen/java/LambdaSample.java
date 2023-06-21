package de.datev.schulungen.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaSample {

    private static double calculate(double x, double y) {
        return x+y;
    }

    private static double calculate2() {
        double sum = 0;
        while(sum <= 10) {
            sum += Math.random();
        }
        return sum;
    }

    // Interface mit 1 abstrakter Methode = Funktionales Interface
    @FunctionalInterface
    private interface NumberGenerator {
        double generateNumber();

    }

    private static double calculate3(NumberGenerator generator) {
        double sum = 0;
        while(sum <= 10) {
            sum += generator.generateNumber();
        }
        return sum;
    }

    private static double calculate4(DoubleSupplier generator) {
        double sum = 0;
        while(sum <= 10) {
            sum += generator.getAsDouble();
        }
        return sum;
    }


    public static void main(String[] args) {
        // addiere 2 Zahlen
        System.out.println(calculate(1.5, 0.8));
        // addiere 2 Zufallszahlen
        System.out.println(calculate(Math.random(), Math.random()));
        // addiere Zufallszahlen solange, bis die Summe > 10
        System.out.println(calculate2());
        // addiere Zahlen solange, bis Summe > 10
        // Entscheidung für Zufallszahlen liegt beim Aufrufer (main)
        System.out.println(calculate3(new NumberGenerator() {
            @Override
            public double generateNumber() {
                return Math.random();
            }
        }));
        // Entferne Redundanzen
        System.out.println(calculate3(() -> {
                return Math.random();
            }
        ));
        // Sonderfall: nur 1 Anweisung
        System.out.println(calculate3(() -> Math.random()));
        // Sonderfall: Parameter Matchen
        System.out.println(calculate3(Math::random)); // Method Reference Operator
        System.out.println(calculate4(Math::random)); // DoubleSupplier

        // Welche Funktionalen Interfaces gibt es schon?
        Supplier<Double> s = Math::random;
        Double sResult = s.get();
        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        c = text -> System.out.println(text);
        c = System.out::println;
        c.accept("Hello World");
        Function<String, Integer> f = text -> Integer.valueOf(text);
        f = Integer::valueOf;
        Integer fResult = f.apply("4");
        Predicate<String> p = text -> text.length()>4;

        Collection<String> namen = Arrays.asList("Ute", "Tom", "Thorsten");
        // alle kurzen Namen (<5) in Großbuchstaben
        {
            Collection<String> kurzNamen = new LinkedList<>();
            for(String name : namen) {
                if(name.length()<5) {
                    kurzNamen.add(name.toUpperCase());
                }
            }
            System.out.println(kurzNamen);
        }
        {
            List<String> kurzNamen = namen.stream()
              .filter(text -> text.length() < 5)
              .map(String::toUpperCase)
              .collect(Collectors.toList());
            System.out.println(kurzNamen);
        }

        namen.forEach(System.out::println);


    }

}
