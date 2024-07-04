package ru.irlix_elementary.spring.model;

public class Person {

    private final int age;
    private final String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{"
                + "age=" + age
                + ", name='" + name + '\''
                + '}';
    }
}
