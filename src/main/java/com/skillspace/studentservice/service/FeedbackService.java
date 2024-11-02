package com.skillspace.studentservice.service;


import com.skillspace.studentservice.models.Feedbacks;
import com.skillspace.studentservice.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public Map<String,List<Feedbacks>> getAllFeedbacks(int project_id) {
        Map<String,List<Feedbacks>> feedbacks = new HashMap<>();
        feedbacks.put("feedbacks",feedbackRepository.getAllFeedbacksByProjectId(project_id));
        return feedbacks;
    }
}
