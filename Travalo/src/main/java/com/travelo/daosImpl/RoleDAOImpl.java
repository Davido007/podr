package com.travelo.daosImpl;

import com.travelo.daos.RoleDAO;
import com.travelo.entities.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ddph on 12/11/2015.
 */
public class RoleDAOImpl implements RoleDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Role getRole(int id) {
        Role role = (Role) getCurrentSession().load(Role.class, id);
        return role;
    }
}
