package com.skillspace.studentservice.service;


import com.skillspace.studentservice.models.Project;
import com.skillspace.studentservice.models.ProjectResponse;
import com.skillspace.studentservice.repository.ProjectRepository;
import com.skillspace.studentservice.repository.TeacherRepository;
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

    @Autowired
    TeacherRepository  teacherRepository;

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

    public Map<String, ProjectResponse> getProjectById(int id) {
        Map<String,ProjectResponse> map = new HashMap<>();
        Project project = projectRepository.getProjectById(id);
        String teacherName = teacherRepository.findNameById((int) project.getTeacher_id());
        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setProject(project);
        projectResponse.setTeacherName(teacherName);
        map.put("projects",projectResponse);
        return map;
    }

    public Map<String,String> updateProjectStatus(int status,int project_id) {
        Map<String,String> map = new HashMap<>();
        if(status == 2 || status == 3) {
            emailService.sendStatusUpdatedNotification(project_id);
            projectRepository.updateProjectStatus(status,project_id);
            map.put("Message","Success");
            return map;
        }
        else{

            if(status == 4) {
                emailService.sendProjectCompletedNotification(project_id);
                projectRepository.updateProjectStatus(status,project_id);
                projectRepository.updateEndDate(project_id);
                map.put("Message","Success");
                return map;

            }
            else{
                map.put("Message","Error");
                return map;
            }
        }
    }

    public Map<String,String> addProject(Project project) {
        Map<String,String> map = new HashMap<>();
        emailService.sendProjectAddedNotification((int) project.getTeacher_id());
        map.put("Message","Success");
        projectRepository.save(project);
        return map;
    }

}
