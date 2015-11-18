package com.travelo.daos;

import com.travelo.entities.UserProfileType;

/**
 * Created by ddph on 18/11/2015.
 */
public interface UserProfileDAO {
    int getProfileId(UserProfileType type);
}
