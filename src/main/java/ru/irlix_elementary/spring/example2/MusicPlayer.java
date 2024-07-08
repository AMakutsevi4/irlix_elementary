package ru.irlix_elementary.spring.example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.System.out;

@Component
public class MusicPlayer {
    private final Music music;
    private final ClassicalMusic classicalMusic;
    private final RockMusic rockMusic;
    private final JazzMusic jazzMusic;
    private final List<Music> musicList;

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic, JazzMusic jazzMusic,
                       @Qualifier("jazzMusic") Music music) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
        this.jazzMusic = jazzMusic;
        this.musicList = List.of(classicalMusic, rockMusic, jazzMusic);
        this.music = music;
    }

    public void playMusic() {
        out.println("Playing: " + classicalMusic.getSong());
        out.println("Playing: " + rockMusic.getSong());
        out.println("Playing: " + jazzMusic.getSong() + "\n");
    }

    public void playAllMusic() {
        for (Music m : musicList) {
            out.println("Playing all: " + m.getSong());
        }
        out.print("\n");
    }

    public void playRandomMusic() {
        out.println("Playing random music: " + music.getRandomSong());
    }
}
