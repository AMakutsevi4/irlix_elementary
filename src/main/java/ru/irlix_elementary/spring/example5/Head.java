package ru.irlix_elementary.spring.example5;

public class Head {

    private final int numberOrbs;
    private final int numberEars;

    public Head(int numberOrbs, int numberEars) {
        this.numberOrbs = numberOrbs;
        this.numberEars = numberEars;
    }

    @Override
    public String toString() {
        return "Head{"
                + "numberOrbs=" + numberOrbs
                + ", numberEars=" + numberEars
                + '}';
    }
}