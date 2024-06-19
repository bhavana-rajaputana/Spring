package com.bhavana.jbdl71spring.service;

import com.bhavana.jbdl71spring.model.Student;
import com.bhavana.jbdl71spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    StudentRepository studentRepository;
    @Autowired
    StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public  Integer createStudent(Student student) {
        return studentRepository.createStudent(student);
    }

    public List<Student> getAllStudents() {
    return studentRepository.getStudents();
    }


}
