package com.bhavana.jbdl71spring.repository;

import com.bhavana.jbdl71spring.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class StudentRepositorySpringJDBC implements IStudentRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    StudentRepositorySpringJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> getStudents() {
        log.info("getStudents");
        return jdbcTemplate.query("select * from studentdata", new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                log.info("mapRow: {}", resultSet);
                return new Student(resultSet.getString("name"), resultSet.getInt("id"));

            }
        });
   // return studentList;
    }


    @Override
    public Integer createStudent(Student student) {
        return null;
    }
}
