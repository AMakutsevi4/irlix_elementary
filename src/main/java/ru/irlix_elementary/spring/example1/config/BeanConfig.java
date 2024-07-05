package ru.irlix_elementary.spring.example1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.irlix_elementary.spring.example1.model.Person;

@Configuration
public class BeanConfig {

    @Bean
    public Person spongeBob() {
        return new Person(12, "SpongeBOB");
    }

    @Bean
    public Person patrick() {
        return new Person(22, "Patrick");
    }

    @Bean
    public Person squidward() {
        return new Person(32, "Squidward");
    }
}
