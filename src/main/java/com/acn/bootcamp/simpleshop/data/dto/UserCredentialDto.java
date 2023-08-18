package com.acn.bootcamp.simpleshop.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class UserCredentialDto {
    public UserCredentialDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String username;
    private String password;
}
