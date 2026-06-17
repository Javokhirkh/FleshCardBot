package com.example.fleshcardservice.controllers;

import com.example.fleshcardservice.dtos.requests.UserCreateDto;
import com.example.fleshcardservice.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.fleshcardservice.controllers.AbstractController.PATH;

@RestController
@RequestMapping(PATH +"/user")
public class UserController extends AbstractController<UserService> {

    protected UserController(UserService service) {
        super(service);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid UserCreateDto dto) {
        service.create(dto);
        return ResponseEntity.ok().body("User created successfully");
    }
}
