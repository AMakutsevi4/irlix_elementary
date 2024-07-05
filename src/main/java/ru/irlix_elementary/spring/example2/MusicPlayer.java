package ru.irlix_elementary.spring.example2;

public class MusicPlayer {
    private Music music;

    /*IoC*/
    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }
}
