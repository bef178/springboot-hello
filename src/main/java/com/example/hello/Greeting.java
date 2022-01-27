package com.example.hello;

import com.example.hello.entity.UserEntity;

public class Greeting {

    private final long count;
    private final String message;
    private final long userId;

    public Greeting(long count, String userName) {
        this.count = count;
        this.message = String.format("Hello %s!", userName);
        this.userId = -1;
    }

    public Greeting(long count, UserEntity user) {
        this.count = count;
        this.message = String.format("Hello %s!", user.name);
        this.userId = user.id;
    }

    public long getCount() {
        return count;
    }

    public String getMessage() {
        return message;
    }

    public long getUserId() {
        return userId;
    }
}
