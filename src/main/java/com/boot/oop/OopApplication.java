package com.boot.oop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class OopApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(OopApplication.class);
        app.run(args);
        log.info("START BOOT WAS");
    }
}
