package com.example.fleshcardservice.services;

import com.example.fleshcardservice.dtos.requests.UserCreateDto;

public interface UserService extends GenericService {

    void create(UserCreateDto dto);
}
