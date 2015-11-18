package com.travelo.daosImpl;

import com.travelo.daos.UserDAO;
import com.travelo.entities.UserEntity;
import com.travelo.entities.UserProfileType;
import com.travelo.services.UserProfileService;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * Created by ddph on 04/11/2015.
 */
public class UserDaoImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserProfileService userProfileService;

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
        if (sessionFactory.getCurrentSession().createQuery("from UserEntity where login = :login").setParameter("login", login).list().size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isEmailUnique(String email) {
        if (sessionFactory.getCurrentSession().createQuery("from UserEntity where email = :email").setParameter("email", email).list().size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserEntity findById(int id) {
        return (UserEntity) sessionFactory.getCurrentSession().createQuery("from UserEntity where id = :id").setParameter("id", id).uniqueResult();
    }

    @Override
    public UserEntity findByLogin(String login) {
        return (UserEntity) sessionFactory.getCurrentSession().createQuery("from UserEntity where login = :login").setParameter("login", login).uniqueResult();

    }
//    public void addUser(UserEntity user) {
//        this.sessionFactory.getCurrentSession().save(user);
//    }

    @Override
    public void addUserRole(UserEntity user) {
        Query query = sessionFactory.getCurrentSession()
                .createSQLQuery("insert into app_user_user_profile (user_id, user_profile_id) values (:user_id, :user_profile_id)")
                .setParameter("user_id", user.getId())
                .setParameter("user_profile_id", userProfileService.getProfileId(UserProfileType.USER));
        query.executeUpdate();
    }

    @Override
    public UserEntity getLoggedUser() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
            return (UserEntity) sessionFactory.getCurrentSession().createQuery("from UserEntity where login = :login").setParameter("login", userName).uniqueResult();
        } else {
            return null;
        }
    }

}
