package com.skillspace.studentservice.service;

import com.skillspace.studentservice.models.Issue;
import com.skillspace.studentservice.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IssueService {
    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    EmailService emailService;

    public Map<String, List<Issue>> getAllIssues(int project_id) {
        Map<String, List<Issue>> issues = new HashMap<>();
        issues.put("issues",issueRepository.getAllIssue(project_id));
        return issues;
    }

    public Map<String,Integer> getOpenIssuesCount(int project_id) {
        Map<String,Integer> openIssues = new HashMap<>();
        openIssues.put("count",issueRepository.getOpenIssueCount(project_id));
        return openIssues;
    }

    public Map<String,Issue> getIssueDetails(int issue_id) {
        Map<String,Issue> issueDetails = new HashMap<>();
        issueDetails.put("issues",issueRepository.getIssueDetails(issue_id));
        return issueDetails;
    }
    public Map<String,String> addIssue(Issue issue) {
        Map<String,String> map = new HashMap<>();
        emailService.sendIssueAddedNotification(issue.getProject_id());
        issueRepository.save(issue);
        map.put("Message","Successfully added issue");
        return map;
    }

    public Map<String,String> updateIssue(int issue_id) {
        Map<String,String> map = new HashMap<>();
        emailService.sendIssueSolvedNotification(issue_id);
        issueRepository.markIssueAsSolved(issue_id);
        map.put("Message","Successfully updated issue");
        return map;
    }
}
