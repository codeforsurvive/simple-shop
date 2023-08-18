package com.acn.bootcamp.simpleshop.data.dto;

import lombok.Data;

@Data
public class AuthenticationResponseDto {
    public AuthenticationResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }

    private String accessToken;
}
