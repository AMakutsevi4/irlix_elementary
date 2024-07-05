package ru.irlix_elementary.spring.example3;

public abstract class Animal {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    /*Метод для получения имени*/
    public String getName() {
        return name;
    }

    /*Абстрактный метод который переопределяем в подклассах*/
    abstract void sayBeforeDeath();
}
