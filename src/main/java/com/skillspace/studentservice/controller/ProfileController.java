package com.skillspace.studentservice.controller;
import com.skillspace.studentservice.util.UsernameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    UsernameUtil usernameUtil;

    @PostMapping("/profile")
    public String getProfile() {

        return "Giving Profile details: "+usernameUtil.getUsername();
    }
}
