package com.example.fleshcardservice.controllers;

import com.example.fleshcardservice.dtos.requests.UserUpdateRequestDto;
import com.example.fleshcardservice.dtos.responses.UserFullResponseDto;
import com.example.fleshcardservice.dtos.responses.UserShortResponseDto;
import com.example.fleshcardservice.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController{

    private final UserServiceImpl userService;

    @GetMapping("/get/{id}")
    public ResponseEntity<UserFullResponseDto> getUser(@PathVariable @Valid Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserShortResponseDto>> getAllUser(){
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<String> UpdateUser(@RequestBody @Valid UserUpdateRequestDto dto){
        userService.update(dto);
        return ResponseEntity.ok("Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable @Valid Long id){
        userService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
