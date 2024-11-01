package com.skillspace.studentservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProjectMedia {
    @Id
    private int project_id;
    private String media_url;


    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }

    @Override
    public String toString() {
        return "ProjectMedia{" +
                "project_id=" + project_id +
                ", media_url='" + media_url + '\'' +
                '}';
    }
}
