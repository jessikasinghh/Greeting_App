package com.example.Greeting_App.Service;

import com.example.Greeting_App.Model.Greeting;
import com.example.Greeting_App.Repository.GreetingRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GreetingService {
    private final GreetingRepository repository;

    public GreetingService(GreetingRepository repository) {
        this.repository = repository;
    }
    public Greeting saveGreeting(Greeting greeting) {
        return repository.save(greeting);
    }


    public List<Greeting> getAllGreetings() {
        return repository.findAll();
    }
}