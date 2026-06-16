package com.example.fleshcardservice.controllers;

import com.example.fleshcardservice.dtos.requests.UserCreateDto;
import com.example.fleshcardservice.dtos.responses.SuccessResponse;
import com.example.fleshcardservice.services.SampleService;
import com.example.fleshcardservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController extends AbstractController<SampleService> {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Validated UserCreateDto dto) {
        userService.createUser(dto);
        return ResponseEntity.ok(SuccessResponse.ok("User created successfully"));
    }
}
