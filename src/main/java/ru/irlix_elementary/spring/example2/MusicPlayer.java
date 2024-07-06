package ru.irlix_elementary.spring.example2;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private Music music;
    private List<Music> musicList = new ArrayList<>();


    public MusicPlayer() {
    }

    /*IoC*/
    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void playAllMusic() {
        for(Music m : musicList) {
            System.out.println("Playing all: " + m.getSong());
        }
    }
}
