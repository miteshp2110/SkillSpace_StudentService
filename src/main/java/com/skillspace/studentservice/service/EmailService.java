package com.skillspace.studentservice.service;

import com.skillspace.studentservice.models.RequestBody;
import com.skillspace.studentservice.models.Teacher;
import com.skillspace.studentservice.repository.IssueRepository;
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

    @Autowired
    IssueRepository issueRepository;

    public void sendProjectAddedNotification(int id ){
        Teacher teacher = teacherRepository.findEmailById(id);
        requestUtil.sentPostRequest(requestBody.projectAddedNotification(teacher.getEmail(),teacher.getName()));
    }
    public void sendStatusUpdatedNotification(int project_id){
        int id = projectRepository.getTeacherId(project_id);
        Teacher teacher = teacherRepository.findEmailById(id);
        requestUtil.sentPostRequest(requestBody.projectStatusUpdatedNotification(teacher.getEmail(),teacher.getName()));
    }

    public void sendProjectCompletedNotification(int project_id){
        int id = projectRepository.getTeacherId(project_id);
        Teacher teacher = teacherRepository.findEmailById(id);
        requestUtil.sentPostRequest(requestBody.projectCompletedNotification(teacher.getEmail(),teacher.getName()));
    }

    public void sendIssueAddedNotification(int project_id){
        int id = projectRepository.getTeacherId(project_id);
        Teacher teacher = teacherRepository.findEmailById(id);
        requestUtil.sentPostRequest(requestBody.sendIssueAddedNotification(teacher.getEmail(),teacher.getName()));
    }

    public void sendIssueSolvedNotification(int issue_id){
        int project_id = issueRepository.getProjectId(issue_id);
        int teacher_id = projectRepository.getTeacherId(project_id);
        Teacher teacher = teacherRepository.findEmailById(teacher_id);
        requestUtil.sentPostRequest(requestBody.sendIssueSolvedNotification(teacher.getEmail(),teacher.getName()));
    }
}
