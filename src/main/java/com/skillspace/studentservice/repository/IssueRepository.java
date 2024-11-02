package com.skillspace.studentservice.repository;


import com.skillspace.studentservice.models.Issue;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {

    @Query(value = "select * from issues where project_id =:project_id",nativeQuery = true)
    public List<Issue> getAllIssue(int project_id);

    @Query(value = "select count(*) from issues where project_id =:project_id and issue_status =1",nativeQuery = true)
    public int getOpenIssueCount(int project_id);

    @Query(value = "select * from issues where issue_id =:issue_id",nativeQuery = true)
    public Issue getIssueDetails(int issue_id);

    @Modifying
    @Transactional
    @Query(value = "update issues set issue_status = 0 where issue_id =:issue_id",nativeQuery = true)
    public void markIssueAsSolved(int issue_id);

    @Query(value = "select project_id from issues where issue_id =:issue_id",nativeQuery = true)
    public int getProjectId(int issue_id);
}
