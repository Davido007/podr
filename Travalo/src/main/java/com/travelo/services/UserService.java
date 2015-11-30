package com.travelo.services;

import com.travelo.entities.MarkerEntity;
import com.travelo.entities.UserEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by ddph on 04/11/2015.
 */
public interface UserService {
    void addUser(UserEntity user);
    List<UserEntity> getAllUsers();
    boolean isLoginUnique(String login);
    boolean isEmailUnique(String email);
    UserEntity getLoggedUser();
    UserEntity findById(int id);
    UserEntity findByLogin(String Login);

    String changeCurrentUserPassword(UserEntity loggedUser, String oldPassword, String newPassword);

    void changeProfileImage(String login, String s);

    List getUserMarkers(String login);

    void addMarker(String title, String note, double latitude, double longitude, Date startDate, Date finishDate);

    MarkerEntity getMarker(String title, double latitude, double longitude);
}
