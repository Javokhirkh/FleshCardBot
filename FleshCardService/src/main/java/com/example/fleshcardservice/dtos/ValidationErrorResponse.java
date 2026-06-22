package com.example.fleshcardservice.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public record ValidationErrorResponse (
        int code,
        String message,
        String language,
        Map<String, List<String>> errors
) implements Serializable {
}