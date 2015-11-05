package com.travelo.daosImpl;

import com.travelo.daos.ImageDAO;
import com.travelo.entities.ImageEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ddph on 05/11/2015.
 */
public class ImageDaoImpl implements ImageDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addImage(ImageEntity image) {
        this.sessionFactory.getCurrentSession().save(image);
    }

    @Override
    public List<ImageEntity> getAllImages() {
        return this.sessionFactory.getCurrentSession().createQuery("from ImageEntity").list();
    }
}
