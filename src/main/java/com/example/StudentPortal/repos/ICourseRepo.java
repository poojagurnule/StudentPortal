package com.example.StudentPortal.repos;

import com.example.StudentPortal.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepo extends JpaRepository<Course, String> {
}
