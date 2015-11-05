package com.travelo.services;

import com.travelo.entities.ImageEntity;

import java.util.List;

/**
 * Created by ddph on 05/11/2015.
 */
public interface ImageService {
    public void addImage(ImageEntity user);
    public List<ImageEntity> getAllImages();
}
