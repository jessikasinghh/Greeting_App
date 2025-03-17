package com.example.Greeting_App.Service;

import com.example.Greeting_App.Model.Greeting;
import com.example.Greeting_App.Repository.GreetingRepository;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final GreetingRepository repository;

    public GreetingService(GreetingRepository repository) {
        this.repository = repository;
    }

    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        return repository.save(greeting);
    }
}
