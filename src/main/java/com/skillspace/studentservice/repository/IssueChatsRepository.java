package com.skillspace.studentservice.repository;

import com.skillspace.studentservice.models.IssueChats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueChatsRepository extends JpaRepository<IssueChats, Integer> {

    @Query(value = "select * from issue_chats where issue_id =:issue_id order by sent_at asc",nativeQuery = true)
    public List<IssueChats> getIssueChatsByIssueId(@Param("issue_id") int issue_id);
}
