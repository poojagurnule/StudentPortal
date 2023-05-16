package com.example.StudentPortal.controllers;

import com.example.StudentPortal.models.Student;
import com.example.StudentPortal.services.StudentService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService ;

   @PostMapping
    public ResponseEntity<String> addStudents(@RequestBody List<Student> studentList){
         String message = studentService.addStudents(studentList);
          return new ResponseEntity<>(message,HttpStatus.CREATED);
   }
    @GetMapping
    public ResponseEntity<List<Student>> getStudent(@Nullable @RequestParam String studentId) {
        List<Student> students = studentService.getStudent(studentId);
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping(value = "{studentId}")
    public String deleteStudentById(@PathVariable String studentId){
        return studentService.deleteStudentById(studentId);
    }





}
