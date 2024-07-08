package ru.irlix_elementary.spring.example5;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.irlix_elementary.spring.example5")
@PropertySource("classpath:application.properties")
public class HydraConfig {
}
