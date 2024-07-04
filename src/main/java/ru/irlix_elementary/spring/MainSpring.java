package ru.irlix_elementary.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.irlix_elementary.spring.config.BeanConfig;
import ru.irlix_elementary.spring.model.Person;

public class MainSpring {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        ApplicationContext contextXML = new ClassPathXmlApplicationContext("applicationContext.xml");


        Person spongeBob = context.getBean("spongeBob", Person.class);
        Person patrick = context.getBean("patrick", Person.class);
        Person squidward = context.getBean("squidward", Person.class);

        /*В данном примере выводим на экран информацию о бинах созданных с помощью аннотаций*/
        System.out.println(spongeBob);
        System.out.println(patrick);
        System.out.println(squidward);

        Person spongeBobXML = (Person) contextXML.getBean("SpongeBobXML");
        Person patrickXML = (Person) contextXML.getBean("PatrickXML");
        Person squidwardXML = (Person) contextXML.getBean("SquidwardXML");

        /*Тут выводим на экран информацию о бинах созданных с помощью application.context*/
        System.out.println(spongeBobXML);
        System.out.println(patrickXML);
        System.out.println(squidwardXML);
    }
}
