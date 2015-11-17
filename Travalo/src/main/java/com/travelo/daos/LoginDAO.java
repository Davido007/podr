package com.travelo.daos;

import com.travelo.entities.LoginParams;
import com.travelo.entities.UserEntity;

/**
 * Created by ddph on 12/11/2015.
 */
public interface LoginDAO {

    UserEntity findByUserName(String username);
    UserEntity login(LoginParams loginParams);
}
