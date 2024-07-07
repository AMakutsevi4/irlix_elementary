package ru.irlix_elementary.spring.example3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HunterMain {


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

//        Hunter hunter = new Hunter();
//
//        /*Вытаскиваем бины из контекста*/
//        Animal frog = context.getBean("FrogBean", Animal.class);
//        Animal goat = context.getBean("GoatBean", Animal.class);
//        Animal goose = context.getBean("GooseBean", Animal.class);
//
//
//        /*Обозначаем имя животного*/
//        hunter.setCurrentAnimal(frog);
//        /*вызываем метод класса Hunter*/
//        hunter.killAnimal();
//
//        hunter.setCurrentAnimal(goat);
//        hunter.killAnimal();
//
//        hunter.setCurrentAnimal(goose);
//        hunter.killAnimal();


        Hunter hunter1 = context.getBean("hunterBean", Hunter.class);
        hunter1.killAnimal();

        /*Загружаем контекст и получаем бин*/
        Hunter hunter2 = context.getBean("hunterBeanFactory", Hunter.class);
        System.out.println(hunter2);


    }
}
