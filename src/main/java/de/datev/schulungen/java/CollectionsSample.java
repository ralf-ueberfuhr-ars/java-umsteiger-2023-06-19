package de.datev.schulungen.java;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class CollectionsSample {

    public static void main(String[] args) {

        Collection<String> c1 = new HashSet<>();
        c1.add("Tom");
        c1.add("Lisa");
        c1.add("Maximilian");
        c1.add("Tim");

        System.out.println(c1);

        Iterator<String> iterator = c1.iterator();
        while(iterator.hasNext()) {
            String name = iterator.next();
            if(name.length()>4) {
                System.out.printf("Lösche Name %s%n", name);
                iterator.remove();
                // c1.remove(name); // ConcurrentModificationException
            }
        }

        for(Iterator<String> it = c1.iterator(); it.hasNext(); ) {
            String name = it.next();
            // ...
        }

        for(String name : c1) {

        }

        System.out.println(c1);

        Collection<String> c2 = new TreeSet<>();
        c2.add("Tom");
        c2.add("Lisa");
        c2.add("Maximilian");
        c2.add("Tim");
        System.out.println(c2);

        Collection<String> c3 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int lengthDiff = o1.length() - o2.length();
                if(lengthDiff == 0) {
                    return o1.compareTo(o2);
                }
                return lengthDiff;
            }
        });
        c3.add("Tom");
        c3.add("Lisa");
        c3.add("Maximilian");
        c3.add("Tim");
        System.out.println(c3);

        String min = min("x", "y");
        int min1 = min(3, 4);
        // Object x = min("x", 1);

        // Raw Types
        String[] strings = {"x", "y"};
        Object[] objects = strings;

        Collection<String> stringCol = Arrays.asList("x", "y");
        //Collection<Object> objectCol = stringCol;

        // Generische Typen sind "Schwesterklassen" mit einer gemeinsamen Oberklasse (Raw Type)
        Collection rawCol = stringCol;

        Collection<Integer> numbers = new HashSet<>();
        numbers.add(3);
        numbers.add(4);
        Collection hack = numbers;
        hack.add("test");

        System.out.println(numbers);

        for(Integer i : numbers) {
            System.out.println(i);
        }

    }

    private static <T extends Comparable<T>> T min(T p1, T p2) {
        return p1.compareTo(p2)>0 ? p2 : p1;
    }


}
