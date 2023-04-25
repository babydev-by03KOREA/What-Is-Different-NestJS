package com.boot.oop.controller;

import com.boot.oop.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping
public class MainController {
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }
    private final MainService mainService;

    @GetMapping
    public String getHello() {
        return mainService.getHello();
    }
}
