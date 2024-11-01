package com.skillspace.studentservice.repository;

import com.skillspace.studentservice.models.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<StudentProfile,String> {

}
