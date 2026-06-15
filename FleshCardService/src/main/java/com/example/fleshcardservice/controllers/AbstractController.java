package com.example.fleshcardservice.controllers;

import com.example.fleshcardservice.services.GenericService;

public abstract class AbstractController<S extends GenericService>{
    private static final String API = "/api";
    private static final String VERSION = "/v1";
    public static final String PATH = API + VERSION;
}
