package com.travelo.servicesImpl;

import com.travelo.daos.UserDAO;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Override
    public void addUser(UserEntity user) {
        userDAO.addUser(user);
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

    public UserEntity findById(int id) {
        return userDAO.findById(id);
    }

    public UserEntity findByLogin(String login) {
        return userDAO.findByLogin(login);
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
