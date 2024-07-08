package ru.irlix_elementary.spring.example2;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "song ROCK music";
    }

    @Override
    public String getRandomSong() {
        return randomRockMusic.getRandomMusic().title;
    }

    public enum randomRockMusic {
        VALUE_ONE("RockMusic sound one"),
        VALUE_TWO("RockMusic sound two"),
        VALUE_THREE("RockMusic sound three");

        private final String title;


        randomRockMusic(String title) {
            this.title = title;
        }

        public static randomRockMusic getRandomMusic() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }
}
