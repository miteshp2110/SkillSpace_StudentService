package com.skillspace.studentservice.controller;


import com.skillspace.studentservice.models.Issue;
import com.skillspace.studentservice.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class IssueController {

    @Autowired
    IssueService issueService;

    @PostMapping("/getOpenIssuesCount")
    public Map<String,Integer> getOpenIssues(@RequestBody Map<String, Integer> map) {
        return issueService.getOpenIssuesCount(map.get("project_id"));
    }

    @PostMapping("getAllIssues")
    public Map<String, List<Issue>> getAllIssues(@RequestBody Map<String, Integer> map) {
        return issueService.getAllIssues(map.get("project_id"));
    }

    @PostMapping("/getIssueDetails")
    public Map<String,Issue> getIssueDetails(@RequestBody Map<String, Integer> map) {
        return issueService.getIssueDetails(map.get("issue_id"));
    }

    @PostMapping("/markIssueSolved")
    public Map<String,String> updateIssueStatus(@RequestBody Map<String, Integer> map) {
        return issueService.updateIssue(map.get("issue_id"));
    }

    @PostMapping("/addIssue")
    public Map<String,String> addIssue(@RequestBody Issue issue) {
        return issueService.addIssue(issue);
    }

    @PostMapping("/getIssueChats")
    public String getIssueChats(@RequestBody Map<String, Integer> map) {
        System.out.println(map.get("issue_id"));
        return "issue chats";
    }

    @PostMapping("/postIssueChat")
    public String postIssueChat(@RequestBody Map<String, Object> map) {
        System.out.println(map.get("issue_id"));
        System.out.println(map.get("message"));
        return "issue chat post";
    }
}
