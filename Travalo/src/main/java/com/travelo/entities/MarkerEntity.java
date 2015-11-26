package com.travelo.entities;

import javax.persistence.*;

/**
 * Created by ddph on 04/11/2015.
 *//*
latitude = event.latLng.lat();
        longitude = event.latLng.lng();*/
@Entity
@Table(name = "MARKERS")
public class MarkerEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "NOTE")
    private String note;
    @Column(name="LATITUDE")
    private double latitude;
    @Column(name="LONGITUDE")
    private double longitude;
    @Column(name = "IMAGEPATH")
    private String imagePath;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID", nullable = false)
    private UserEntity userEntitys;

    public void setUserEntitys(UserEntity userEntitys) {
        this.userEntitys = userEntitys;
    }

/*    public MarkerEntity(String title, String note, double latitude, double longitude) {
        this.title = title;
        this.note = note;
        this.latitude = latitude;
        this.longitude= longitude;
    }*/



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
