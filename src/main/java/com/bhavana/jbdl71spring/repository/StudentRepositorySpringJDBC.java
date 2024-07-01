package com.bhavana.jbdl71spring.repository;

import com.bhavana.jbdl71spring.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class StudentRepositorySpringJDBC implements IStudentRepository {

    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    StudentRepositorySpringJDBC(NamedParameterJdbcTemplate jdbcTemplate) {
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
log.info("In create Student StudentRepositorySpringJDBC");
       // return jdbcTemplate.update("INSERT INTO studentdata (name, id) VALUES (?, ?)", student.getName(), student.getId());
       // return null;
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name" , student.getName());
        parameterSource.addValue("id" , student.getId());
        return jdbcTemplate.update("insert into studentdata (name, id) values (:name, :id)", parameterSource);

    }
}
