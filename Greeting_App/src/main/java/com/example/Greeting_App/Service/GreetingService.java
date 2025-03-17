package com.example.Greeting_App.Service;


import com.example.Greeting_App.Model.Greeting;
import com.example.Greeting_App.Repository.GreetingRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GreetingService {
    private final GreetingRepository repository;

    public GreetingService(GreetingRepository repository) {
        this.repository = repository;
    }

    public Greeting saveGreeting(String message) {
        return repository.save(new Greeting(message));
    }

    public Greeting findGreetingById(Long id) {
        return repository.findById(id).orElse(null);
    }
}