package com.travelo.daos;



import com.travelo.entities.ImageEntity;

import java.util.List;

/**
 * Created by ddph on 04/11/2015.
 */
public interface ImageDAO
{
    public void addImage(ImageEntity image);
    List<ImageEntity> getAllImages();
}
