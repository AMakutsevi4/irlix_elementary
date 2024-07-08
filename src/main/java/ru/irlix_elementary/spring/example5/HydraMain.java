package ru.irlix_elementary.spring.example5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HydraMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(HydraConfig.class);
        /*Достаём бин hydra из контекста*/
        Hydra hydra = context.getBean("hydra", Hydra.class);
        /*Выводим бин на экран*/
        System.out.println(hydra);
        /*Закрываем контекст, данная процедура необходима для освобождения ресурсов*/
        context.close();
    }
}
