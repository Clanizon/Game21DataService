package com.game.service;

import java.util.List;

import com.game.dto.UserDto;
import com.game.model.user.User;


public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(int id);

   

    User findByUserId(String id);

    UserDto update(UserDto userDto);
}
