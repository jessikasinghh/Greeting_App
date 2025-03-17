package com.example.Greeting_App.Repository;


import com.example.Greeting_App.Model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}