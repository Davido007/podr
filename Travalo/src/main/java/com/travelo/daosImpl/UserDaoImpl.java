package com.travelo.daosImpl;

import com.travelo.daos.UserDAO;
import com.travelo.entities.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ddph on 04/11/2015.
 */
public class UserDaoImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void addUser(UserEntity user) {
        this.sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserEntity> getAllUsers() {
        return this.sessionFactory.getCurrentSession().createQuery("from UserEntity").list();
    }
}
