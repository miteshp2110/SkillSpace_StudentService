package com.skillspace.studentservice.service;


import com.skillspace.studentservice.models.Project;
import com.skillspace.studentservice.repository.ProjectRepository;
import com.skillspace.studentservice.util.UsernameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UsernameUtil usernameUtil;

    @Autowired
    EmailService emailService;

    public Map<String,List<Project>> getAllProjects() {
        String email = usernameUtil.getUsername();
        Map<String,List<Project>> projects = new HashMap<>();
        projects.put("projects",projectRepository.getAllProjects(email));
        return projects;
    }

    public Map<String,Integer> getTotalProjectsCount() {
        String email = usernameUtil.getUsername();
        Map<String,Integer> map = new HashMap<>();
        map.put("count",projectRepository.getTotalProjectCount(email));
        return map;
    }

    public Map<String,Integer> getCompletedProjectsCount() {
        String email = usernameUtil.getUsername();
        Map<String,Integer> map = new HashMap<>();
        map.put("count",projectRepository.getCompletedProjectsCount(email));
        return map;
    }

    public Map<String,Integer> getOngoingProjectsCount() {
        String email = usernameUtil.getUsername();
        Map<String,Integer> map = new HashMap<>();
        map.put("count",projectRepository.getongoingProjectsCount(email));
        return map;
    }

    public Map<String,Project> getProjectById(int id) {
        Map<String,Project> map = new HashMap<>();
        map.put("projects",projectRepository.getProjectById(id));
        return map;
    }

    public Map<String,String> updateProjectStatus(int status,int project_id) {
        Map<String,String> map = new HashMap<>();
        emailService.sendStatusUpdatedNotification(project_id);
        projectRepository.updateProjectStatus(status,project_id);
        map.put("Message","Success");
        return map;
    }

    public Map<String,String> addProject(Project project) {
        Map<String,String> map = new HashMap<>();
        emailService.sendProjectAddedNotification((int) project.getTeacher_id());
        map.put("Message","Success");
        projectRepository.save(project);
        return map;
    }

}
