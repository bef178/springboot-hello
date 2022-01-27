package com.example.hello.mapper;

import com.example.hello.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    boolean createUser(UserEntity user);

    List<UserEntity> retrieveUserById(long id);

    List<UserEntity> retrieveAllUsers();
}
