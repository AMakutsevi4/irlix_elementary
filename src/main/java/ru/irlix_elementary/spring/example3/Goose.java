package ru.irlix_elementary.spring.example3;

public class Goose extends Animal {

    public Goose(String name) {
        super(name);
    }

    @Override
    void sayBeforeDeath() {
        System.out.println("K-R-Y-A K-R-Y-A");
    }
}
