package com.skillspace.studentservice.repository;

import com.skillspace.studentservice.models.Feedbacks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedbacks,Integer> {

    @Query(value = "select * from feedbacks where project_id =:project_id",nativeQuery = true)
    public List<Feedbacks> getAllFeedbacksByProjectId(@Param("project_id") int project_id);
}
