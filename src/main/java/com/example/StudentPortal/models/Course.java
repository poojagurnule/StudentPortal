package com.example.StudentPortal.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course_table")
public class Course {
    @Id
    private String Id;
    private String courseTitle;
    private String courseDescription;
    private String courseDuration;

    @ManyToMany(mappedBy = "courses")
    private List<Student> studentList;
}
