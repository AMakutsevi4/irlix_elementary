package ru.irlix_elementary.spring.example2;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "song ROCK music";
    }
}
