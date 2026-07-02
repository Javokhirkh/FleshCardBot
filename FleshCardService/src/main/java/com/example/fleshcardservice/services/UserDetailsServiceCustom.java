package com.example.fleshcardservice.services;

import com.example.fleshcardservice.entities.User;
import com.example.fleshcardservice.exceptions.customs.UserNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

public interface UserDetailsServiceCustom extends UserDetailsService {

    UserDetails loadUserByUsername(String username) throws UserNotFoundException;

    User getCurrentUser();  // gets currently authenticated user

    boolean isAuthenticated();  // checks if user is logged in
}
