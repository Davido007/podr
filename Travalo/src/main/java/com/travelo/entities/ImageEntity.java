package com.travelo.entities;

import javax.persistence.*;

/**
 * Created by ddph on 05/11/2015.
 */
@Entity
@Table(name = "IMAGES")
public class ImageEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;
    @Column(name = "IMAGEPATH")
    private String imagePath;
    @Column(name = "NOTE")
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
