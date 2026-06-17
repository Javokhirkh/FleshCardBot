package com.example.fleshcardservice.services.impl;

import com.example.fleshcardservice.dtos.requests.UserCreateDto;
import com.example.fleshcardservice.entities.Users;
import com.example.fleshcardservice.repositories.UserRepository;
import com.example.fleshcardservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void create(UserCreateDto dto) {
        Users user = Users.builder()
                .chatId(dto.chatId())
                .build();
        userRepository.save(user);
    }

    //public Users findUserById(String id) {}
}
