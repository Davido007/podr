package com.travelo.services;

import com.travelo.entities.LoginParams;
import com.travelo.entities.UserEntity;

/**
 * Created by ddph on 16/11/2015.
 */
public interface LoginService {
    UserEntity login(LoginParams loginParams);
}
