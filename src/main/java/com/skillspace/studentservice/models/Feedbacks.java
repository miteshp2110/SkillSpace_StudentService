package com.skillspace.studentservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "feedbacks")
public class Feedbacks {
    @Id
    private int project_id;
    private String feedback;

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Feedbacks{" +
                "project_id=" + project_id +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
