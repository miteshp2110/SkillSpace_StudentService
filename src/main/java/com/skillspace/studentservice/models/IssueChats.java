package com.skillspace.studentservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "issue_chats")
public class IssueChats {
    @Id
    private int issue_id;
    private String message;
    private String sender_email;

    public int getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender_email() {
        return sender_email;
    }

    public void setSender_email(String sender_email) {
        this.sender_email = sender_email;
    }

    @Override
    public String toString() {
        return "IssueChats{" +
                "issue_id=" + issue_id +
                ", message='" + message + '\'' +
                ", sender_email='" + sender_email + '\'' +
                '}';
    }
}
