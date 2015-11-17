package com.travelo.services;

import com.travelo.entities.UserEntity;

import java.util.List;

/**
 * Created by ddph on 04/11/2015.
 */
public interface UserService {
    void addUser(UserEntity user);
    List<UserEntity> getAllUsers();
    boolean isLoginUnique(String login);
    boolean isEmailUnique(String email);

    UserEntity findById(int id);
    UserEntity findByLogin(String Login);
}
