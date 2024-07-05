package ru.irlix_elementary.spring.example3;

public class Goat extends Animal {

    public Goat(String name) {
        super(name);
    }

    @Override
    void sayBeforeDeath() {
        System.out.println("B-E-E-E B-E-E-E");
    }
}
