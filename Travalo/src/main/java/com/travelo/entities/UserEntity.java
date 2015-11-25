package com.travelo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ddph on 04/11/2015.
 */
@Entity
@Table(name = "USERS")
public class UserEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "EMAIL", unique=true, nullable=false)
    private String email;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "CITY")
    private String city;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "LOGIN", unique=true, nullable=false)
    private String login;
    @Column(name = "IMAGEPATH", nullable=false)
    private String imagePath;
    @Column(name="STATE", nullable=false)
    private String state=State.ACTIVE.getState();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "APP_USER_USER_PROFILE",
            joinColumns = { @JoinColumn(name = "USER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
