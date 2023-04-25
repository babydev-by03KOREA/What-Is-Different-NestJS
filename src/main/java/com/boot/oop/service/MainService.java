package com.boot.oop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MainService {
    public String getHello() {
        log.info("getHello Method Start Boot");
        return "<h1>Hello World! By Boot</h1>";
    }
}
