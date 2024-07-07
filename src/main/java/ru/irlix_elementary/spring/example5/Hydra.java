package ru.irlix_elementary.spring.example5;

import java.util.List;

public class Hydra {

    private final String name;
    private final List<Head> headList;


    public Hydra(String name, List<Head> headList) {
        this.name = name;
        this.headList = headList;
    }


    @Override
    public String toString() {
        return "Hydra{"
                + "name='" + name + '\''
                + ", headList=" + headList
                + '}';
    }
}
