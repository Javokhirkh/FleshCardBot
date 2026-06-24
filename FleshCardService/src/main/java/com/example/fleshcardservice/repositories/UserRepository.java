package com.example.fleshcardservice.repositories;

import com.example.fleshcardservice.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByUsername(String username);
}
