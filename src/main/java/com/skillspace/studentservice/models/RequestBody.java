package com.skillspace.studentservice.models;

import org.springframework.stereotype.Component;

@Component
public class RequestBody {
    private final String company = "SkillSpace";

    public String projectAddedNotification(String email,String name){


        return String.format(
                """
                {
                    "company":"%s",
                    "notificationTitle":"Project Added",
                    "notificationBody" : "A student has added a project under your supervision, go checkout and give feedbacks and solve issues.",
                    "recipientName":"%s",
                    "recipient":"%s"
                }
                """,company,name,email
        );
    }
    public String projectStatusUpdatedNotification(String email,String name){


        return String.format(
                """
                {
                    "company":"%s",
                    "notificationTitle":"Project Update!!",
                    "notificationBody" : "Status of a project has been updated. Go Checkout !!!",
                    "recipientName":"%s",
                    "recipient":"%s"
                }
                """,company,name,email
        );
    }
}
