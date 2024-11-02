package com.skillspace.studentservice.repository;


import com.skillspace.studentservice.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {


    @Query(value = "select * from project where student_id = (select id from student where email =:email)", nativeQuery = true)
    public List<Project> getAllProjects(@Param("email")String email);

    @Query(value = "select count(*) from project where student_id = (select id from student where email =:email)",nativeQuery = true)
    public int getTotalProjectCount(@Param("email")String email);

    @Query(value = "select * from project where project_id =:project_id",nativeQuery = true)
    public Project getProjectById(@Param("project_id")int project_id);

    @Query(value = "select count(*) from project where status_level = 4 and student_id = (select id from student where email =:email)",nativeQuery = true)
    public int getCompletedProjectsCount(@Param("email")String email);

    @Query(value = "select count(*) from project where status_level != 4 and student_id = (select id from student where email =:email)",nativeQuery = true)
    public int getongoingProjectsCount(@Param("email")String email);

    @Modifying
    @Transactional
    @Query(value = "update project set status_level =:status where project_id =:project_id" , nativeQuery = true)
    public int updateProjectStatus(@Param("status")int status, @Param("project_id")int project_id);

    @Query(value = "select teacher_id from project where project_id =:project_id",nativeQuery = true)
    public int getTeacherId(@Param("project_id")int project_id);

    @Modifying
    @Transactional
    @Query(value = "update project set end_date = current_date where project_id =:project_id",nativeQuery = true)
    public int updateEndDate(@Param("project_id")int project_id);

}
