package com.travelo.daosImpl;

import com.travelo.daos.UserDAO;
import com.travelo.entities.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
    @Override
    public boolean isLoginUnique(String login) {
        if(sessionFactory.getCurrentSession().createQuery("from UserEntity where login = :login").setParameter("login",login).list().size() == 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isEmailUnique(String email) {
        if(sessionFactory.getCurrentSession().createQuery("from UserEntity where email = :email").setParameter("email",email).list().size() == 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserEntity findById(int id) {
        return (UserEntity) sessionFactory.getCurrentSession().createQuery("from UserEntity where id = :id").setParameter("id",id).uniqueResult();
    }

    @Override
    public UserEntity findByLogin(String login) {
        return (UserEntity) sessionFactory.getCurrentSession().createQuery("from UserEntity where login = :login").setParameter("login",login).uniqueResult();

    }

}
