package com.hry.train.batch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello world2132q42343sadfsd12312f";
    }
}
