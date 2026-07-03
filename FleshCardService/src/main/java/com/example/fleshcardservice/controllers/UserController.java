package com.example.fleshcardservice.controllers;

import com.example.fleshcardservice.dtos.requests.UserUpdateRequestDto;
import com.example.fleshcardservice.dtos.responses.UserFullResponseDto;
import com.example.fleshcardservice.dtos.responses.UserShortResponseDto;
import com.example.fleshcardservice.services.UserService;
import com.example.fleshcardservice.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.fleshcardservice.controllers.AbstractController.PATH;

@RestController
@RequestMapping(PATH+"/user")
public class UserController extends AbstractController<UserService>{


    protected UserController(UserService service) {
        super(service);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserFullResponseDto> getUser(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<UserShortResponseDto>> getAllUser(){
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping()
    public ResponseEntity<Void> UpdateUser(@RequestBody @Valid UserUpdateRequestDto dto){
        service.update(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
