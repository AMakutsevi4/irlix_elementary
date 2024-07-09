package ru.irlix_elementary.spring.example8;

import java.lang.reflect.Method;

import static java.lang.System.out;

public class DiscountMain {

    public static void addDiscount(Product product) {

        /*Получаем все методы класса*/
        for (Method method : product.getClass().getDeclaredMethods()) {
            /*Проверяем каждый метод на наличие нашей аннотации*/
            if (method.isAnnotationPresent(Discount.class)) {
                /*Если аннотация присутствует, извлекаем из неё значение и применяем*/
                Discount discount = method.getAnnotation(Discount.class);
                int oldPrice = product.getPrice();
                int newPrice = discount.value();
                out.println("Старая цена " + product.getName()
                        + ": " + oldPrice + " рублей.");
                out.println("Новая цена " + product.getName()
                        + ": " + (oldPrice - oldPrice * newPrice / 100) + " рублей.");

                product.setPrice(oldPrice - oldPrice * newPrice / 100);
            }
        }
    }

    public static void main(String[] args) {
        Product product = new Product("Chocolate", 100);
        addDiscount(product);
        out.println(product);
        out.println(product.getPrice());

    }
}
