package com.skillspace.studentservice.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class IssueController {

    @PostMapping("/getOpenIssues")
    public String getOpenIssues(@RequestBody Map<String, Integer> map) {
        System.out.println(map.get("project_id"));
        return "open issues";
    }

    @PostMapping("getAllIssues")
    public String getAllIssues(@RequestBody Map<String, Integer> map) {
        System.out.println(map.get("project_id"));
        return "all issues";
    }

    @PostMapping("/getIssueDetails")
    public String getIssueDetails(@RequestBody Map<String, Integer> map) {
        System.out.println(map.get("issue_id"));
        return "issue details";
    }

    @PostMapping("/updateIssueStatus")
    public String updateIssueStatus(@RequestBody Map<String, Object> map) {
        System.out.println(map.get("issue_id"));
        System.out.println(map.get("status"));
        return "update issue";
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
