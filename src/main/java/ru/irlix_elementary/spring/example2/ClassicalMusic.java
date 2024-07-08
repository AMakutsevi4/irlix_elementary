package ru.irlix_elementary.spring.example2;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ClassicalMusic implements Music{
    @Override
    public String getSong() {
        return "song CLASSICAL music";
    }

    @Override
    public String getRandomSong() {
        return randomClassicalMusic.getRandomMusic().title;
    }

    public enum randomClassicalMusic {
        VALUE_ONE("ClassicalMusic sound one"),
        VALUE_TWO("ClassicalMusic sound two"),
        VALUE_THREE("ClassicalMusic sound three");

        private final String title;


        randomClassicalMusic(String title) {
            this.title = title;
        }

        public static randomClassicalMusic getRandomMusic() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }
}
