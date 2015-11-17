package com.travelo.daosImpl;

import com.travelo.daos.LoginDAO;
import com.travelo.entities.LoginParams;
import com.travelo.entities.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ddph on 12/11/2015.
 */
@Repository("loginDao")
public class LoginDaoImpl implements LoginDAO{

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public UserEntity findByUserName(String username) {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        UserEntity user = (UserEntity) session.load(UserEntity.class, new String(username));
        tx.commit();
        return user;
    }

    @Override
    public UserEntity login(LoginParams loginParams) {
        List queryObject = sessionFactory.getCurrentSession().createQuery("from UserEntity where login = :login and password = :password").setParameter("login",loginParams.getLogin()).setParameter("password", loginParams.getPassword()).list();
        UserEntity userEntity;
        if(queryObject.size() != 0){
            userEntity = (UserEntity) queryObject.get(0);
            return userEntity;
        } else {
            return null;
        }
    }

}
