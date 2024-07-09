package ru.irlix_elementary.spring.example7;

import java.lang.reflect.Method;

import static java.lang.System.out;

public class MainAnnotation {

    public static void main(String[] args) {

        SetupValue setupValue = new SetupValue();

        /*Получаем все методы класса*/
        for (Method method : setupValue.getClass().getDeclaredMethods()) {
            /*Проверяем каждый метод на наличие нашей аннотации*/
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                /*Если аннотация присутствует, извлекаем из неё значение и выводим*/
                MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
                out.println(myAnnotation.value());
            }
        }
    }
}
