package com.skillspace.studentservice.controller;

import com.skillspace.studentservice.models.Feedbacks;
import com.skillspace.studentservice.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @PostMapping("/getFeedback")
    public Map<String,List<Feedbacks>> getFeedbacks(@RequestBody Map<String,Integer> map) {
        return feedbackService.getAllFeedbacks(map.get("project_id"));
    }
}
