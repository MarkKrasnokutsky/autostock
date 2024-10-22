package com.mark.autostock.controller;

import com.mark.autostock.domain.entity.UserEntity;
import com.mark.autostock.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/get/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userRepository.getUserById(id);
    }

    @GetMapping("/getAll")
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

}
