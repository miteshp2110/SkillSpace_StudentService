package com.skillspace.studentservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class StudentProfile {


    private int id;
    @Id
    private String email;
    private String name;
    private String branch;
    private String bio;
    private String profileImage_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfileImage_url() {
        return profileImage_url;
    }

    public void setProfileImage_url(String profileImage_url) {
        this.profileImage_url = profileImage_url;
    }

    @Override
    public String toString() {
        return "StudentProfile{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", bio='" + bio + '\'' +
                ", profileImage_url='" + profileImage_url + '\'' +
                '}';
    }
}
