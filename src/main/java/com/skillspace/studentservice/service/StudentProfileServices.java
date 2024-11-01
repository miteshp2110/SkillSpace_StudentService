package com.skillspace.studentservice.service;

import com.skillspace.studentservice.models.StudentProfile;
import com.skillspace.studentservice.repository.StudentRepository;
import com.skillspace.studentservice.util.UsernameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StudentProfileServices {
    @Autowired
    UsernameUtil usernameUtil;

    @Autowired
    StudentRepository studentRepository;

    public Optional<StudentProfile> getProfile()
    {
        return studentRepository.findById(usernameUtil.getUsername());
    }

}
