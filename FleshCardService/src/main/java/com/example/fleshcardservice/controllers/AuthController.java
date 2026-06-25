package com.example.fleshcardservice.controllers;

import com.example.fleshcardservice.config.security.JwtUtil;
import com.example.fleshcardservice.dtos.requests.LoginRequest;
import com.example.fleshcardservice.dtos.requests.UserCreateRequestDto;
import com.example.fleshcardservice.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.example.fleshcardservice.controllers.AbstractController.PATH;

@RestController
@RequiredArgsConstructor
@RequestMapping(PATH +"/auth")
public class AuthController{

    private final JwtUtil jwtUtil;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.userName(), loginRequest.password()
        ));
        String token = jwtUtil.generateToken(loginRequest.userName());
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserCreateRequestDto dto) {
        userService.create(dto);
        return ResponseEntity.ok().body("User created successfully");
    }

}
