package com.travelo.services;

import com.travelo.entities.UserEntity;

import java.util.List;

/**
 * Created by ddph on 04/11/2015.
 */
public interface UserService {
    public void addUser(UserEntity user);
    public List<UserEntity> getAllUsers();
}
