package com.bhavana.jbdl71spring.controller;

import com.bhavana.jbdl71spring.model.Student;
import com.bhavana.jbdl71spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getAllStudents();

    }

    @PostMapping("/student")
    public Integer addStudent(@RequestBody Student student) {
        if(student.getName()==null){

            throw new IllegalArgumentException("Mandatory parameters are null");
        }
        return studentService.createStudent(student);
    }
}



