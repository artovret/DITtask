package com.example.task4.dto;

import com.example.task4.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPasswordDto {
    private String username;
    private String password;

    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

    public static UserPasswordDto fromUser(User user) {
        UserPasswordDto userRegisterDto = new UserPasswordDto();
        userRegisterDto.setUsername(user.getUsername());
        userRegisterDto.setPassword(user.getPassword());
        return userRegisterDto;
    }
}
