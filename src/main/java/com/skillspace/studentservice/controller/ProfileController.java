package com.skillspace.studentservice.controller;
import com.skillspace.studentservice.models.StudentProfile;
import com.skillspace.studentservice.service.StudentProfileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class ProfileController {

    @Autowired
    private StudentProfileServices studentProfileServices;

    @PostMapping("/getProfile")
    public Optional<StudentProfile> getProfile() {
        return studentProfileServices.getProfile();
    }



}
