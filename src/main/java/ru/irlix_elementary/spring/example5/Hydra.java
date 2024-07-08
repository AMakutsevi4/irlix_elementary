package ru.irlix_elementary.spring.example5;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Hydra {

    private final String name;
    private final List<Head> headList;

    @Autowired
    public Hydra(@Value("${hydra.name}") String name) {
        this.name = name;
        this.headList = List.of(new Head(2, 3),
                new Head(4, 5),
                new Head(6, 7));
    }

    @PostConstruct
    public void doMyInit() {
        System.out.println("Здесь возможна инициализация ресурсов, "
                + "обращение к внешним файлам, запуск БД");
    }

    @PreDestroy
    public void doMyDestroy() {
        System.out.println("Здесь возможно очищение ресурсов, "
                + "закрытие потоков ввода-вывода, закрытие доступа к БД");
    }

    @Override
    public String toString() {
        return "Hydra{"
                + "name='" + name + '\''
                + ", headList=" + headList
                + '}';
    }
}
