package com.skillspace.studentservice.controller;


import com.skillspace.studentservice.models.IssueChats;
import com.skillspace.studentservice.service.IssueChatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class IssueChatController {

    @Autowired
    IssueChatsService issueChatsService;

    @PostMapping("/getIssueChats")
    public Map<String, List<IssueChats>> getIssueChats(@RequestBody Map<String, Integer> map) {
        return issueChatsService.getIssueChats(map.get("issue_id"));
    }

    @PostMapping("/postIssueChat")
    public Map<String,String> postIssueChat(@RequestBody Map<String,Object> map) {
        return issueChatsService.postIssueChats((int) map.get("issue_id"),(String) map.get("message"));
    }
}
