package ca.gbc.comp3095.lecture3.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String sayHello() {
        System.out.println("Hello World");
        return "hi folks";
    }
}
