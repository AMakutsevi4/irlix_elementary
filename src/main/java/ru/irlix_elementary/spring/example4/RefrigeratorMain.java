package ru.irlix_elementary.spring.example4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * В данном примере использование интерфейса необходимо
 * для соблюдения принципа ООП полиморфизм. т.е. мы используем объекты разных типов.
 */
public class RefrigeratorMain {
    public static void main(String[] args) {
        /*Загружаем файл конфигурации и создаем объект context*/
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("refrigeratorApplicationContext.xml");
        /*Из контекста достаем бин холодильник и выводим на экран весь список продуктов методом getAllProducts()*/
        Refrigerator refrigerator = context.getBean("Refrigerator", Refrigerator.class);

        refrigerator.getAllProducts();
        /*Выводим на экран объект с помощью метода toString() */
        System.out.println(refrigerator);
    }
}
