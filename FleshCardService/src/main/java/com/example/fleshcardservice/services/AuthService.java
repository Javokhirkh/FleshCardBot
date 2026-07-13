package com.example.fleshcardservice.services;

public interface AuthService extends GenericService{
    String authenticate(String username, String password);
}
