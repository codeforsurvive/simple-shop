package com.acn.bootcamp.simpleshop.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserCredential {
    public UserCredential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String username;
    private String password;
}
