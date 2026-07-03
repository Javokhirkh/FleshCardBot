package com.example.fleshcardservice.services.impl;

import com.example.fleshcardservice.dtos.requests.UserCreateRequestDto;
import com.example.fleshcardservice.dtos.requests.UserUpdateRequestDto;
import com.example.fleshcardservice.dtos.responses.UserFullResponseDto;
import com.example.fleshcardservice.dtos.responses.UserShortResponseDto;
import com.example.fleshcardservice.entities.User;
import com.example.fleshcardservice.enums.Role;
import com.example.fleshcardservice.exceptions.customs.UserNotFoundException;
import com.example.fleshcardservice.mapper.UserMapper;
import com.example.fleshcardservice.repositories.UserRepository;
import com.example.fleshcardservice.services.UserDetailsServiceCustom;
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
    private final UserDetailsServiceCustom userDetailsServiceCustom;

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
        User currentUser = userDetailsServiceCustom.getCurrentUser();

        boolean isAdmin = currentUser.getRole() == Role.ADMIN;
        User target = isAdmin && dto.id() != null
                ? getUserById(dto.id())
                : currentUser;
        if (dto.userName() != null) target.setUserName(dto.userName());
        if (dto.password() != null) target.setPassword(encoder.encode(dto.password()));
        if (dto.dailyGoal() != null) target.setDailyGoal(dto.dailyGoal());
        if (dto.dailyNewLimit() != null) target.setDailyNewLimit(dto.dailyNewLimit());
        if (dto.reminderTime() != null) target.setReminderTime(dto.reminderTime());
        repository.save(target);
    }

    @Override
    public UserFullResponseDto getById(Long id) {
        return mapper.toFullDto(getUserById(id));
    }

    @Override
    public List<UserShortResponseDto> getAll() {
        User currentUser = userDetailsServiceCustom.getCurrentUser();
        boolean isAdmin = currentUser.getRole() == Role.ADMIN;

        if (!isAdmin) {
            return null;
        }

        return repository.findAllByIsDeletedFalse()
                .stream()
                .map(mapper::toShortDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        User currentUser = userDetailsServiceCustom.getCurrentUser();

        boolean isAdmin = currentUser.getRole() == Role.ADMIN;
        if (isAdmin) {
            repository.trash(id);
        }
    }


    private User getUserById(Long id) {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
