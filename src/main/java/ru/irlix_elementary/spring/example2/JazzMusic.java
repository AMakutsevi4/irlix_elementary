package ru.irlix_elementary.spring.example2;

import org.springframework.stereotype.Component;

@Component
public class JazzMusic implements Music{
    @Override
    public String getSong() {
        return "song JAZZ music";
    }
}
