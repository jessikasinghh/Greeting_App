package com.example.Greeting_App.Service;


import com.example.Greeting_App.Dto.AuthUserDTO;
import com.example.Greeting_App.Dto.LoginDTO;
import com.example.Greeting_App.Model.AuthUser;
import com.example.Greeting_App.Repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private AuthUserRepository authUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    public String registerUser(AuthUserDTO userDTO) {
        if (authUserRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            return "Email is already in use";
        }

        AuthUser user = new AuthUser();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        authUserRepository.save(user);

        emailService.sendEmail(user.getEmail(), "Registration Successful",
                "Welcome " + user.getFirstName() + "! Your account has been created.");

        return "User registered successfully!";
    }

    public String loginUser(LoginDTO loginDTO) {
        Optional<AuthUser> user = authUserRepository.findByEmail(loginDTO.getEmail());
        if (user.isEmpty()) {
            return "User not found!";
        }

        if (!passwordEncoder.matches(loginDTO.getPassword(), user.get().getPassword())) {
            return "Invalid email or password!";
        }

        return "Login successful!";
    }
}