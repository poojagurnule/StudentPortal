package com.example.StudentPortal.services;

import com.example.StudentPortal.models.Student;
import com.example.StudentPortal.repos.IStudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@Service

public class StudentService {
    @Autowired
    IStudentRepo iStudentRepo;

    public String addStudents(List<Student> studentList) {
        Iterable<Student> students = iStudentRepo.saveAll(studentList);
        if (students == null) {
            return "Students not added successfully.";
        }
        return "Students added successfully.";

    }

    public List<Student> getStudent(String studentId) {

        List<Student> list = new ArrayList<>();
        if (studentId == null) {
            return iStudentRepo.findAll();
        } else {
            list.add(iStudentRepo.findById(studentId).get());
            return list;
        }

    }


    public String deleteStudentById(String studentId) {
        Optional<Student> list = iStudentRepo.findById(studentId);

        if (!(list.isEmpty())) {
           iStudentRepo.deleteById(studentId);
            return "Student with id " + studentId+ " deleted successfully";
        }
        return "Student with id " + studentId+ " not found";
    }



}