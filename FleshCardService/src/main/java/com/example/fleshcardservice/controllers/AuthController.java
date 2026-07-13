package com.example.fleshcardservice.controllers;

import com.example.fleshcardservice.dtos.requests.LoginRequest;
import com.example.fleshcardservice.dtos.requests.UserCreateRequestDto;
import com.example.fleshcardservice.services.impl.AuthServiceImpl;
import com.example.fleshcardservice.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.example.fleshcardservice.controllers.AbstractController.PATH;

@RestController
@RequiredArgsConstructor
@RequestMapping(PATH +"/auth")
public class AuthController {

    private final AuthServiceImpl authService;
    private final UserServiceImpl userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest) {
        String token = authService.authenticate(loginRequest.userName(), loginRequest.password());
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid UserCreateRequestDto dto) {
        userService.create(dto);
        return ResponseEntity.ok().body("User created successfully");
    }

}
