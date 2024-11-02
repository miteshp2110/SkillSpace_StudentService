package com.skillspace.studentservice.controller;


import com.skillspace.studentservice.models.ProjectMedia;
import com.skillspace.studentservice.service.ProjectMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
public class ProjectMediaController {

    @Autowired
    ProjectMediaService projectMediaService;

    @PostMapping("/addProjectMedia")
    public Map<String,String> addProjectMedia(@RequestParam("project_id")String project_id, @RequestParam("media") MultipartFile[] media) {

        return projectMediaService.addProjectMedia(media,project_id);
    }

    @PostMapping("/getProjectMedia")
    public Map<String, List<ProjectMedia>> getProjectMedia(@RequestBody Map<String, Integer> projectDetails) {
        return projectMediaService.getAllProjectMedia(projectDetails.get("project_id"));
    }

}
