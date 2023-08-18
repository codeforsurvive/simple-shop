package com.acn.bootcamp.simpleshop.data.dto;

import com.acn.bootcamp.simpleshop.data.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class UserDto extends UserCredentialDto{
    private String username;
    private String name;
    private String registrationNumber;
    private Role role;

    public UserDto(String username, String name, String registrationNumber, Role role) {
        this.name = name;
        this.username = username;
        this.registrationNumber = registrationNumber;
        this.role = role;
    }
}
