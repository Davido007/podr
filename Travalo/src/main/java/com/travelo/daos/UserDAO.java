package com.travelo.daos;

import com.travelo.entities.UserEntity;

import java.util.List;

/**
 * Created by ddph on 04/11/2015.
 */
public interface UserDAO
{
    void addUser(UserEntity user);
    List<UserEntity> getAllUsers();
    boolean isLoginUnique(String login);
    boolean isEmailUnique(String email);
    UserEntity findById(int id);
    UserEntity findByLogin(String login);
    void addUserRole(UserEntity user);
    UserEntity getLoggedUser();
}