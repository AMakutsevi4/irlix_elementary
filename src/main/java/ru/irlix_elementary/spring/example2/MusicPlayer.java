package ru.irlix_elementary.spring.example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MusicPlayer {

    private final ClassicalMusic classicalMusic;
    private final RockMusic rockMusic;
    private final JazzMusic jazzMusic;
    private final List<Music> musicList;

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic, JazzMusic jazzMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
        this.jazzMusic = jazzMusic;
        this.musicList = List.of(classicalMusic, rockMusic, jazzMusic);
    }


    public void playMusic() {
        System.out.println("Playing: " + classicalMusic.getSong());
        System.out.println("Playing: " + rockMusic.getSong());
        System.out.println("Playing: " + jazzMusic.getSong());
    }


    public void playAllMusic() {
        for (Music m : musicList) {
            System.out.println("Playing all: " + m.getSong());
        }
    }
}
