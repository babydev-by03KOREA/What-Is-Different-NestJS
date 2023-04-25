package com.boot.oop.injection;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyBean {
    public void injection() {
        log.info("DEPENDENCY INJECTION BEAN");
    }
}
