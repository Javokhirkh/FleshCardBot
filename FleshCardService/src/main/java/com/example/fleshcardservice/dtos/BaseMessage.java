package com.example.fleshcardservice.dtos;

import java.io.Serializable;

public record BaseMessage(
        int code,
        String message
) implements Serializable {
}
