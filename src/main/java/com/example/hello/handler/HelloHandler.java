package com.example.hello.handler;

import com.example.hello.Greeting;
import com.example.hello.entity.UserEntity;
import com.example.hello.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class HelloHandler {

    private final AtomicLong counter = new AtomicLong();

    @Resource
    private UserMapper userMapper;

    public Greeting hello(long userId) {
        List<UserEntity> users = userMapper.retrieveUserById(userId);
        if (users == null || users.isEmpty()) {
            throw new RuntimeException("fail to retrieve user");
        }
        return hello(users.get(0));
    }

    public Greeting hello(UserEntity user) {
        return new Greeting(counter.incrementAndGet(), user);
    }

    public Greeting hello(String name) {
        return new Greeting(counter.incrementAndGet(), name);
    }
}
