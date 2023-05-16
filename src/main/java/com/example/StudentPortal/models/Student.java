package com.example.StudentPortal.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_table")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "studentID")

public class Student {
    @Id

    private String studentId;
    private String studentName;
    private String studentAge;
    private String studentPhoneNumber;
    private String studentBranch;
    private String studentDepartment;
    @OneToOne(cascade = CascadeType.ALL)
    private  Address address;

    @ManyToMany
    @JoinTable(name = "student_courses")
    private List<Course> courses;

    @OneToOne
    private Laptop laptop;
}
