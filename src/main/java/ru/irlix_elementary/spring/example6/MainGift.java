package ru.irlix_elementary.spring.example6;

public class MainGift {

    /*Фбричный метод, просто возвращает разные объекты в зависимости от параметра
    Полезно когда только во время выполнения поймём какой объект нам нужен*/
    public static void main(String[] args) {
        GiftFactory giftFactory = new GiftFactory();
        System.out.println( giftFactory.createGift(15).getName());
    }
}
