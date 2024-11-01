package com.skillspace.studentservice.repository;


import com.skillspace.studentservice.models.ProjectMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProjectMediaRepository extends JpaRepository<ProjectMedia, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into project_media(project_id,media_url) values (:project_id,:url)",nativeQuery = true)
    public void insertMedia(@Param("project_id")int project_id, @Param("url")String url);

    @Query(value = "select * from project_media where project_id =:project_id",nativeQuery = true)
    public List<ProjectMedia> getProjectMediaById(@Param("project_id") int project_id);


}
