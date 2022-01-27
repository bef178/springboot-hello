package com.example.hello.controller;

import com.example.hello.Greeting;
import com.example.hello.handler.HelloHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private HelloHandler helloHandler;

    @GetMapping("/hello")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return helloHandler.hello(name);
    }

    @GetMapping("/hello/users/{id}")
    public Greeting greeting(@PathVariable(value = "id") long userId) {
        return helloHandler.hello(userId);
    }
}
