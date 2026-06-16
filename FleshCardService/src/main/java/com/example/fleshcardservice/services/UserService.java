package com.example.fleshcardservice.services;

import com.example.fleshcardservice.dtos.requests.UserCreateDto;
import com.example.fleshcardservice.entities.Users;
import com.example.fleshcardservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserCreateDto dto) {
        Users user = Users.builder()
                .chatId(dto.chatId())
                .build();
        userRepository.save(user);
    }

    //public Users findUserById(String id) {}
}
