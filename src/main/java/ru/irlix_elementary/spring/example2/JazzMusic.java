package ru.irlix_elementary.spring.example2;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class JazzMusic implements Music {
    @Override
    public String getSong() {
        return "song JAZZ music";
    }

    @Override
    public String getRandomSong() {
        return randomJazzMusic.getRandomJazzMusic().title;
    }

    public enum randomJazzMusic {
        VALUE_ONE("JazzMusic sound one"),
        VALUE_TWO("JazzMusic sound one"),
        VALUE_THREE("JazzMusic sound one");

        private final String title;

        randomJazzMusic(String title) {
            this.title = title;
        }

        public static randomJazzMusic getRandomJazzMusic() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }
}
