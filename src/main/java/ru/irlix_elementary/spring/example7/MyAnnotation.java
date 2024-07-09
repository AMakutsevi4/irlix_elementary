package ru.irlix_elementary.spring.example7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*Аннотация будет доступна во время выполнения программы*/
@Retention(RetentionPolicy.RUNTIME)
/*Указываем к каким элементам может быть применена аннотация*/
@Target(ElementType.METHOD)
public @interface MyAnnotation {

    String value() default "Hello! i'm annotation";
}
