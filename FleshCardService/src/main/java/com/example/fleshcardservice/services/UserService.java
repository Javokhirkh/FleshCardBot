package com.example.fleshcardservice.services;

import com.example.fleshcardservice.dtos.requests.UserCreateRequestDto;
import com.example.fleshcardservice.dtos.requests.UserUpdateRequestDto;
import com.example.fleshcardservice.dtos.responses.UserFullResponseDto;
import com.example.fleshcardservice.dtos.responses.UserShortResponseDto;

import java.util.List;

public interface UserService extends GenericService {

    void create(UserCreateRequestDto dto);

    void update(UserUpdateRequestDto dto);

    UserFullResponseDto getById(Long id);

    List<UserShortResponseDto> getAll();

    void delete(Long id);
}
