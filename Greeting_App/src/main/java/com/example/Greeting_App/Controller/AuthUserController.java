package com.example.Greeting_App.Controller;


import com.example.Greeting_App.Dto.AuthUserDTO;
import com.example.Greeting_App.Dto.LoginDTO;
import com.example.Greeting_App.Service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthUserController {
    private final AuthenticationService service;

    public AuthUserController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthUserDTO userDTO) {
        return ResponseEntity.ok(service.registerUser(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(service.loginUser(loginDTO));
    }
}