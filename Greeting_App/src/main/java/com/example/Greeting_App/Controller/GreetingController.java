package com.example.Greeting_App.Controller;

import com.example.Greeting_App.Model.Greeting;
import com.example.Greeting_App.Service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/greetings")
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PostMapping
    public Greeting saveGreeting(@RequestParam String message) {
        Greeting greeting = new Greeting(message);
        return greetingService.saveGreeting(greeting);
    }

    @GetMapping
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
}