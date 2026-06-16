package com.example.fleshcardservice.dtos.responses;

import com.example.fleshcardservice.dtos.Dto;
import lombok.Builder;

@Builder
public record SuccessResponse (
    String message,
    boolean status,
    int code
) implements Dto {

    public  static SuccessResponse ok(String message){
        return SuccessResponse.builder()
                .message(message)
                .status(true)
                .code(200)
                .build();
    }
}
