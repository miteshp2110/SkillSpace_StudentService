package com.skillspace.studentservice.service;

import com.skillspace.studentservice.models.RequestBody;
import com.skillspace.studentservice.models.Teacher;
import com.skillspace.studentservice.repository.ProjectRepository;
import com.skillspace.studentservice.repository.TeacherRepository;
import com.skillspace.studentservice.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    RequestUtil requestUtil;

    @Autowired
    RequestBody requestBody;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    ProjectRepository projectRepository;

    public void sendProjectAddedNotification(int id ){
        Teacher teacher = teacherRepository.findEmailById(id);
        requestUtil.sentPostRequest(requestBody.projectAddedNotification(teacher.getEmail(),teacher.getName()));
    }
    public void sendStatusUpdatedNotification(int project_id){
        int id = projectRepository.getTeacherId(project_id);
        Teacher teacher = teacherRepository.findEmailById(id);
        requestUtil.sentPostRequest(requestBody.projectStatusUpdatedNotification(teacher.getEmail(),teacher.getName()));
    }
}
