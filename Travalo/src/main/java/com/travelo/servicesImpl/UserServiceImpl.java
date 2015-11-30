package com.travelo.servicesImpl;

import com.travelo.daos.UserDAO;
import com.travelo.entities.MarkerEntity;
import com.travelo.entities.UserEntity;
import com.travelo.entities.UserProfile;
import com.travelo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ddph on 04/11/2015.
 */
@Service("securityUserService")
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;

    @Autowired
    private UserEntity userEntity;

    @Override
    public void addUser(UserEntity user) {
        userDAO.addUser(user);
        userDAO.addUserRole(user);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public boolean isLoginUnique(String login) {
        return userDAO.isLoginUnique(login);
    }

    @Override
    public boolean isEmailUnique(String email) {
        return userDAO.isEmailUnique(email);
    }

    @Override
    public UserEntity getLoggedUser() {
        return userDAO.getLoggedUser();
    }

    public UserEntity findById(int id) {
        return userDAO.findById(id);
    }

    public UserEntity findByLogin(String login) {
        return userDAO.findByLogin(login);
    }

    @Override
    public String changeCurrentUserPassword(UserEntity loggedUser, String oldPassword, String newPassword) {
        if(!oldPassword.equals(loggedUser.getPassword())){
            return "Fail";
        }
        return userDAO.changeCurrentUserPassword(loggedUser, newPassword);
    }

    @Override
    public void changeProfileImage(String login, String path) {
        userDAO.changeProfileImage(login, path);
    }

    @Override
    public List getUserMarkers(String login) {
        return userService.getLoggedUser().getMarkers();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
    public void addMarker(String title, String note, double latitude, double longitude, Date startDate, Date finishDate) {
/*        markerEntity.setTitle(title);
        markerEntity.setNote(note);
        markerEntity.setLatitude(latitude);
        markerEntity.setLongitude(longitude);
        markerEntity.setUser(userService.getLoggedUser());*/
        userDAO.addMarker(userService.getLoggedUser(),title, note, latitude, longitude, startDate, finishDate);
    }

    @Override
    public MarkerEntity getMarker(String title, double latitude, double longitude) {
        return userDAO.getMarker(title, userService.getLoggedUser(), latitude, longitude);
    }


    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        UserEntity user = userService.findByLogin(login);
        System.out.println("User : "+user);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
    }


    private List<GrantedAuthority> getGrantedAuthorities(UserEntity user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(UserProfile userProfile : user.getUserProfiles()){
            System.out.println("UserProfile : "+userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }
}
