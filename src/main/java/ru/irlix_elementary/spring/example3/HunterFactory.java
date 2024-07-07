package ru.irlix_elementary.spring.example3;

public class HunterFactory {

    /*Плюсы использования фабричного метода:
    * 1. Логика создания объекта скрыта внутри фабричного метода;
    * 2. Если потребуется изменить логику создания объекта, изменения нужно будет внести только сюда;
    */
    public static Hunter createHunter() {
        return new Hunter("Alex", "Gun");
    }
}
