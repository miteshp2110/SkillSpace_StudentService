package com.skillspace.studentservice.repository;

import com.skillspace.studentservice.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query(value = "select * from teacher where id =:id",nativeQuery = true)
    public Teacher findEmailById(@Param("id") int id);
}

