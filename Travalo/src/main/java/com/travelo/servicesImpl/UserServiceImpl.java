package com.travelo.servicesImpl;

import com.travelo.daos.UserDAO;
import com.travelo.entities.UserEntity;
import com.travelo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ddph on 04/11/2015.
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    @Transactional
    public void addUser(UserEntity user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public List<UserEntity> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
