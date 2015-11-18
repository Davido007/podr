package com.travelo.daosImpl;

import com.travelo.daos.UserProfileDAO;
import com.travelo.entities.UserProfileType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ddph on 18/11/2015.
 */
public class UserProfileDaoImpl implements UserProfileDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int getProfileId(UserProfileType type) {

        return (Integer) sessionFactory.getCurrentSession().createSQLQuery("select id from user_profile where type = :type").setParameter("type", String.valueOf(type)).uniqueResult();

    }
}
