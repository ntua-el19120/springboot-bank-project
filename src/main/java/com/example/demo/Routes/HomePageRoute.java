package com.example.demo.Routes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageRoute {
     @GetMapping("/")
    public String hello() {
        return "Hello World";
    }
}
