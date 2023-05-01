package com.boot.oop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MainService {
    public String getHello() {
        log.info("getHello Method Start BOOT");
        return "<h1>Hello World! By Boot</h1>";
    }

    public String printParam(Object param) {
        log.info("printParam Request by BOOT");
        return "<h1>" + param + " REQUEST by BOOT" + "</h1>";
    }
}
