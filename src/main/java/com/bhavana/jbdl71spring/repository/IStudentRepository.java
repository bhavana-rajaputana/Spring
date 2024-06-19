package com.bhavana.jbdl71spring.repository;

import com.bhavana.jbdl71spring.model.Student;

import java.util.List;

public interface IStudentRepository {
     List<Student> getStudents();
     Integer createStudent(Student student);

}
