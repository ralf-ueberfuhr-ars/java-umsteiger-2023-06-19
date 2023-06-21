package de.datev.schulungen.java;

import lombok.Builder;

public class BuilderSample {

    @Builder
    private static class Person {

        private int age;
        private String name;

    }

    public static void main(String[] args) {
        Person p = Person.builder()
          .age(18)
          .name("Tom")
          .build();
    }


}
