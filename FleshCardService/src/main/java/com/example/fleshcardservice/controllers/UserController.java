package com.example.fleshcardservice.controllers;

import com.example.fleshcardservice.dtos.requests.UserCreateDto;
import com.example.fleshcardservice.services.SampleService;
import com.example.fleshcardservice.services.UserService;
import com.example.fleshcardservice.services.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<String> create(@RequestBody @Validated UserCreateDto dto) {
        service.create(dto);
        return ResponseEntity.ok().body("User created successfully");
    }
}
