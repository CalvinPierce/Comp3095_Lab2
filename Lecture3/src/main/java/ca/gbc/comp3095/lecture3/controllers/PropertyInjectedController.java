package ca.gbc.comp3095.lecture3.controllers;

import ca.gbc.comp3095.lecture3.services.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
