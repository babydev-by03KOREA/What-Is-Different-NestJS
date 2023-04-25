package com.boot.oop.injection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
