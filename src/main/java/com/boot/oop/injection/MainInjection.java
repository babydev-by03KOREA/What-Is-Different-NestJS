package com.boot.oop.injection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bean")
public class MainInjection {

    private final MyBean myBean;

    public MainInjection(MyBean myBean) {
        this.myBean = myBean;
    }

    @GetMapping
    public String execute() {
        myBean.injection();
        return "<h1>BEAN DI</h1>";
    }
}
