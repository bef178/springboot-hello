package com.example.hello.controller;

import com.example.hello.entity.UserEntity;
import com.example.hello.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserMapper userMapper;

    @PostMapping("/users")
    public UserEntity createUser(@RequestBody String name) {
        UserEntity user = new UserEntity();
        user.name = name;
        if(!userMapper.createUser(user)) {
            throw new RuntimeException("fail to create user");
        }
        return user;
    }

    @GetMapping("/users")
    public List<UserEntity> retrieveAllUsers() {
        return userMapper.retrieveAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserEntity retrieveUserById(@PathVariable long id) {
        List<UserEntity> users = userMapper.retrieveUserById(id);
        if (users == null || users.isEmpty()) {
            throw new RuntimeException("fail to create user");
        }
        return users.get(0);
    }
}
