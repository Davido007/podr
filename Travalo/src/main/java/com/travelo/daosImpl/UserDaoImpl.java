package com.travelo.daosImpl;

import com.travelo.daos.UserDAO;
import com.travelo.entities.MarkerEntity;
import com.travelo.entities.UserEntity;
import com.travelo.entities.UserProfileType;
import com.travelo.services.UserProfileService;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
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

    @Override
    public String changeCurrentUserPassword(UserEntity loggedUser, String newPassword) {
        Query query = sessionFactory.getCurrentSession().createQuery("update UserEntity set password = :newPassword" +
                " where login = :login");
        query.setParameter("newPassword", newPassword);
        query.setParameter("login", loggedUser.getLogin());
        int result = query.executeUpdate();
/*

        if (sessionFactory.getCurrentSession().createQuery("from UserEntity where login = :login").setParameter("login", login).list().size() == 0) {
            return true;
        } else {
            return false;
        }*/

        return "Success";
    }

    @Override
    public void changeProfileImage(String login, String path) {
        Query query = sessionFactory.getCurrentSession().createQuery("update UserEntity set imagePath = :imagePath" +
                " where login = :login");
        query.setParameter("imagePath", path);
        query.setParameter("login", login);
        int result = query.executeUpdate();
    }

    @Override
    public void addMarker(UserEntity loggedUser, String title, String note, double latitude, double longitude) {
        List markers = new ArrayList();
        MarkerEntity markerEntity = new MarkerEntity();
        markerEntity.setTitle(title);
        markerEntity.setNote(note);
        markerEntity.setLatitude(latitude);
        markerEntity.setLongitude(longitude);
        markerEntity.setUserEntitys(loggedUser);
        markers.add(markerEntity);
        //markerEntity.setUser(loggedUser);
        System.out.println("1111111111111111111111111111");
        UserEntity userEntity = (UserEntity) this.sessionFactory.getCurrentSession().get(UserEntity.class,loggedUser.getId());
        System.out.println("111111111111111111111111111122222");
        userEntity.setMarkers(markers);
        System.out.println("1111111111111111111111111111222223333333");
        this.sessionFactory.getCurrentSession().update(userEntity);
        //this.sessionFactory.getCurrentSession().flush();
        System.out.println("11111111111111111111111111112222233333334444444");

        //this.sessionFactory.getCurrentSession().save(markerEntity);
    }

}
