package com.bhavana.jbdl71spring.service;

import com.bhavana.jbdl71spring.model.Student;
import com.bhavana.jbdl71spring.repository.IStudentRepository;
import com.bhavana.jbdl71spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    IStudentRepository istudentRepository;

    @Autowired
    StudentService(@Qualifier("studentRepositorySpringJDBC") IStudentRepository istudentRepository) {
        this.istudentRepository =  istudentRepository;
    }


//    StudentService(@Qualifier("studentRepository") IStudentRepository istudentRepository) {
//        this.istudentRepository =  istudentRepository;
//    }



    public  Integer createStudent(Student student) {
        return istudentRepository.createStudent(student);
    }

    public List<Student> getAllStudents() {
    return istudentRepository.getStudents();
    }


}
