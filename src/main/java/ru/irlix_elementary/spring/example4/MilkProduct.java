package ru.irlix_elementary.spring.example4;

public class MilkProduct implements Product {

    private int percentFat;

    public MilkProduct(int percentFat) {
        this.percentFat = percentFat;
    }

    @Override
    public String toString() {
        return "MilkProduct{"
                + "percentFat=" + percentFat
                + '}';
    }
}
