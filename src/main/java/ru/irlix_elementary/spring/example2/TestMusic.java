package ru.irlix_elementary.spring.example2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestMusic {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(MusicConfig.class);

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        
        musicPlayer.playMusic();
        musicPlayer.playAllMusic();
        musicPlayer.playRandomMusic();
    }
}
