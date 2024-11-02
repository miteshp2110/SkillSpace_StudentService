package com.skillspace.studentservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "issue_chats")
public class IssueChats {

    @Id
    @Column(insertable = false)
    private int chat_id;

    private int issue_id;
    private String message;
    private String sender_email;

    @Column(insertable = false)
    private String sent_at;

    public String getSent_at() {
        return sent_at;
    }

    public void setSent_at(String sent_at) {
        this.sent_at = sent_at;
    }

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
