package com.skillspace.studentservice.controller;

import com.skillspace.studentservice.models.Project;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
public class ProjectController {

    @PostMapping("/totalProject")
    public String getProjectDetails() {
        return "number of project";
    }


    @PostMapping("/ongoingProject")
    public String onGoingProjects() {
        return "Ongoing Projects";
    }

    @PostMapping("/completedProject")
    public String completedProject() {
        return "Completed Project";
    }

    @PostMapping("/addProject")
    public String addProject(@RequestBody Project project) {
        System.out.println(project);
        return "Add Project";
    }

    @PostMapping("/getAllProjects")
    public String getAllProjects() {
        return "All Projects";
    }

    @PostMapping("/getProjectDetails")
    public String getProjectDetails(@RequestBody Map<String, Integer> projectDetails) {
        System.out.println(projectDetails.get("project_id"));
        return "Project Details";
    }

    @PostMapping("/updateProjectStatus")
    public String updateProjectStatus(@RequestBody Map<String, Integer> projectDetails) {
        System.out.println(projectDetails.get("project_id"));
        System.out.println(projectDetails.get("status"));
        return "Update Project";
    }

    @PostMapping("/addProjectMedia")
    public String addProjectMedia(@RequestParam("project_id")String project_id, @RequestParam("media")MultipartFile media) {
        System.out.println(project_id);
        System.out.println(media.getOriginalFilename());
        return "Add Project Media";
    }

    @PostMapping("/getProjectMedia")
    public String getProjectMedia(@RequestBody Map<String, Integer> projectDetails) {
        System.out.println(projectDetails.get("project_id"));
        return "Project Media";
    }

}
