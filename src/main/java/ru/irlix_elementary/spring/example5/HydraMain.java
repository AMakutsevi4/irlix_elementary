package ru.irlix_elementary.spring.example5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HydraMain {

    public static void main(String[] args) {
        /*Создаем объект context для дальнейшей работы с бинами*/
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        /*Достаём бин hydra из контекста*/
        Hydra hydra = context.getBean("hydra", Hydra.class);
        /*Выводим бин на экран*/
        System.out.println(hydra);
        /*Закрываем контекст, данная процедура необходима для освобождения ресурсов*/
        context.close();
    }
}
