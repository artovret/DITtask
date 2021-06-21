package com.example.task4.rest;


import com.example.task4.dto.AdminUserDto;
import com.example.task4.dto.RoleRequestDto;
import com.example.task4.dto.UserPasswordDto;
import com.example.task4.dto.StatusRequestDto;
import com.example.task4.model.User;
import com.example.task4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/")
public class AdminRestController {

    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/id/{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        AdminUserDto userDto = AdminUserDto.fromUser(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("users/name/{name}")
    public ResponseEntity<AdminUserDto> getUserByName(@PathVariable(name = "name") String name) {
        User user = userService.findByUsername(name);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        AdminUserDto userDto = AdminUserDto.fromUser(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }


    @PostMapping("users/status")
    public ResponseEntity statusUpdate(@RequestBody StatusRequestDto statusRequestDto) {
        try {
            userService.changeStatus(statusRequestDto.getUsername(), statusRequestDto.getStatus());
            Map<Object, Object> response = new HashMap<>();
            response.put("username", statusRequestDto.getUsername());
            response.put("NEW STATUS", statusRequestDto.getStatus());
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Ошибка при смене статуса");
        }
    }

    @PostMapping("update/password")
    public ResponseEntity passwordUpdate(@RequestBody UserPasswordDto authenticationRequestDto) {
        try {
            User user = userService.findByUsername(authenticationRequestDto.getUsername());
            user.setPassword(authenticationRequestDto.getPassword());
            userService.passwordUpdate(user);
            Map<Object, Object> response = new HashMap<>();
            response.put("username", authenticationRequestDto.getUsername());
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Ошибка при регистрации пользователя");
        }
    }

    @PostMapping("update/role")
    public ResponseEntity roleUpdate(@RequestBody RoleRequestDto requestDto) {
        try {
            User user = userService.findByUsername(requestDto.getUsername());
            userService.roleUpdate(user, requestDto.getRoles());
            Map<Object, Object> response = new HashMap<>();
            response.put("username", requestDto.getUsername());
            response.put("Role", requestDto.getRoles());
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Ошибка при регистрации пользователя");
        }
    }


}
