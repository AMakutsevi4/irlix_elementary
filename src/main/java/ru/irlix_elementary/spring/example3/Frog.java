package ru.irlix_elementary.spring.example3;

public class Frog extends Animal {
    /*Вызов конструктора родительского класса*/
    public Frog(String name) {
        super(name);
    }

    @Override
    void sayBeforeDeath() {
        System.out.println("K-W-A K-W-A");
    }
}
