package com.travelo.servicesImpl;

import com.travelo.daos.LoginDAO;
import com.travelo.entities.LoginParams;
import com.travelo.entities.UserEntity;
import com.travelo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ddph on 16/11/2015.
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDAO loginDAO;

    @Override
    public UserEntity login(LoginParams loginParams) {
        return loginDAO.login(loginParams);
    }
}
