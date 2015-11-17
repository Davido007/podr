package com.travelo.servicesImpl;

import com.travelo.daos.ImageDAO;
import com.travelo.entities.ImageEntity;
import com.travelo.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ddph on 05/11/2015.
 */
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDAO imageDAO;

    @Override
    @Transactional
    public void addImage(ImageEntity image) {
        imageDAO.addImage(image);
    }

    @Override
    @Transactional
    public List<ImageEntity> getAllImages() {
        return imageDAO.getAllImages();
    }

    @Override
    @Transactional
    public List<ImageEntity> getPopularImages() {
        return imageDAO.getPopularImages();
    }

}
