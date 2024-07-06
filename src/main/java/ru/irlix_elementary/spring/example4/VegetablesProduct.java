package ru.irlix_elementary.spring.example4;

public class VegetablesProduct implements Product {

    private String nameTree;

    public VegetablesProduct(String nameTree) {
        this.nameTree = nameTree;
    }

    @Override
    public String toString() {
        return "VegetablesProduct{"
                + "nameTree='" + nameTree + '\''
                + '}';
    }
}
