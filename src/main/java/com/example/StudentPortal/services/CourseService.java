package com.example.StudentPortal.services;

import com.example.StudentPortal.models.Course;
import com.example.StudentPortal.repos.ICourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private ICourseRepo courseRepository;



    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(String id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.orElse(null);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(String id, Course course) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (existingCourse.isPresent()) {
            course.setId(existingCourse.get().getId());
            return courseRepository.save(course);
        }
        return null;
    }

    public boolean deleteCourse(String id) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (existingCourse.isPresent()) {
            courseRepository.delete(existingCourse.get());
            return true;
        }
        return false;
    }
}
