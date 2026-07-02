package com.example.fleshcardservice.services.impl;

import com.example.fleshcardservice.dtos.requests.UserCreateRequestDto;
import com.example.fleshcardservice.dtos.requests.UserUpdateRequestDto;
import com.example.fleshcardservice.dtos.responses.UserFullResponseDto;
import com.example.fleshcardservice.dtos.responses.UserShortResponseDto;
import com.example.fleshcardservice.entities.User;
import com.example.fleshcardservice.exceptions.customs.UserNotFoundException;
import com.example.fleshcardservice.mapper.UserMapper;
import com.example.fleshcardservice.repositories.UserRepository;
import com.example.fleshcardservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final UserMapper mapper;

    @Override
    public void create(UserCreateRequestDto dto) {
        User user = User.builder()
                .userName(dto.userName())
                .password(encoder.encode(dto.password()))
                .build();
        repository.save(user);
    }

    @Override
    public void update(UserUpdateRequestDto dto) {
        User user = this.getUserById(dto.id());
        user.setPassword(encoder.encode(dto.password()));
        repository.save(user);
    }

    @Override
    public UserFullResponseDto getById(Long id) {
        User user = this.getUserById(id);
        return mapper.toFullDto(user);
    }

    @Override
    public List<UserShortResponseDto> getAll() {
        return repository.findAllByIsDeletedFalse()
                .stream()
                .map(mapper::toShortDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        this.getUserById(id);
        repository.trash(id);
    }


    private User getUserById(Long id) {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
