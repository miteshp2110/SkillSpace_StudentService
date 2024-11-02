package com.skillspace.studentservice.service;


import com.skillspace.studentservice.models.IssueChats;
import com.skillspace.studentservice.repository.IssueChatsRepository;
import com.skillspace.studentservice.util.UsernameUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IssueChatsService {
    @Autowired
    IssueChatsRepository issueChatsRepository;

    @Autowired
    UsernameUtil usernameUtil;

    public Map<String, List<IssueChats>> getIssueChats(int issue_id) {
        HashMap<String, List<IssueChats>> issueChats = new HashMap<>();
        issueChats.put("chats",issueChatsRepository.getIssueChatsByIssueId(issue_id));
        return issueChats;
    }

    public Map<String,String> postIssueChats(int issue_id, String message) {
        HashMap<String, String> response = new HashMap<>();
        IssueChats issueChats = new IssueChats();
        issueChats.setIssue_id(issue_id);
        issueChats.setMessage(message);
        issueChats.setSender_email(usernameUtil.getUsername());
        issueChatsRepository.save(issueChats);
        response.put("Message","Successfully posted issue chat");
        return response;
    }
}
