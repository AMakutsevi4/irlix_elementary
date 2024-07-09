package ru.irlix_elementary.spring.example8;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private String name;
    private int price;

    @Discount(30)
    public int getPrice() {
        return this.price;
    }
}
