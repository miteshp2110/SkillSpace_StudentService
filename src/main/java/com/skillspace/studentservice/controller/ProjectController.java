package com.skillspace.studentservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String addProject() {
        return "Add Project";
    }


}
