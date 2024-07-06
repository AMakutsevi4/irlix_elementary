package ru.irlix_elementary.spring.example2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMusic {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        /*Создаем объект music, который реализует интерфейс Music*/
        Music music = context.getBean("MusicBean", Music.class);
        /*Созданный объект music внедряем в player*/
        MusicPlayer musicPlayer = new MusicPlayer(music);
        /*музыкальный плеер использует вышеописанную зависимость и выполняет метод playMusic*/
        musicPlayer.playMusic();

        /*Получаем бин musicPlayer и вызываем метод для перечисления всей музыки*/
        MusicPlayer musicPlayer1 = context.getBean("PlayAllMusic", MusicPlayer.class);

        musicPlayer1.playAllMusic();
        /*Закрываем контекст*/
        context.close();
    }
}
