package ru.irlix_elementary.spring.example2;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMusic {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        musicPlayer.playMusic();
        musicPlayer.playAllMusic();
    }
}
