package ru.irlix_elementary.spring.example4;

import java.util.ArrayList;
import java.util.List;

public class Refrigerator {

    public Refrigerator(String model) {
        this.model = model;
    }

    private String model;
    private List<Product> productList = new ArrayList<>();


    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void getAllProducts() {
        for (Product p : productList) {
            System.out.println(p.toString());
        }
    }

    @Override
    public String toString() {
        return "Refrigerator{"
                + "model='" + model + '\''
                + ", productList=" + productList
                + '}';
    }
}
