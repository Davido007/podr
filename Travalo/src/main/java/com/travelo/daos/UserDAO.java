package com.travelo.daos;

import com.travelo.entities.UserEntity;

import java.util.List;

/**
 * Created by ddph on 04/11/2015.
 */
public interface UserDAO
{
    public void addUser(UserEntity user);
    List<UserEntity> getAllUsers();
}