package com.travelo.servicesImpl;

import com.travelo.daos.UserProfileDAO;
import com.travelo.entities.UserProfileType;
import com.travelo.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ddph on 18/11/2015.
 */
@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    UserProfileDAO userProfileDAO;

    @Override
    public int getProfileId(UserProfileType type) {
        return userProfileDAO.getProfileId(type);
    }
}
