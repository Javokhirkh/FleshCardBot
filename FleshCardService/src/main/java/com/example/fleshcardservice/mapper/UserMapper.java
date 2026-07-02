package com.example.fleshcardservice.mapper;

import com.example.fleshcardservice.dtos.responses.UserFullResponseDto;
import com.example.fleshcardservice.dtos.responses.UserShortResponseDto;
import com.example.fleshcardservice.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "username", target = "userName")
    UserShortResponseDto toShortDto(User user);

    @Mapping(source = "username", target = "userName")
    UserFullResponseDto toFullDto(User user);
}
