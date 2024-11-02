package com.skillspace.studentservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "issues")
public class Issue {

    private int project_id;

    @Id
    @Column(insertable = false)
    private int issue_id;

    private String issue_title;
    private String issue_description;

    @Column(insertable = false)
    private boolean issue_status;

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

    public String getIssue_title() {
        return issue_title;
    }

    public void setIssue_title(String issue_title) {
        this.issue_title = issue_title;
    }

    public String getIssue_description() {
        return issue_description;
    }

    public void setIssue_description(String issue_description) {
        this.issue_description = issue_description;
    }

    public boolean isIssue_status() {
        return issue_status;
    }

    public void setIssue_status(boolean issue_status) {
        this.issue_status = issue_status;
    }
}
