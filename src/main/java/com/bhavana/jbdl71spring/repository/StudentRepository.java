package com.bhavana.jbdl71spring.repository;

import com.bhavana.jbdl71spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    Connection connection;

    @Autowired
    public StudentRepository(Connection connection) {
       this.connection=connection;
        createTable();
    }

    public  Integer createStudent(Student student) {
//        try {
//            return connection.createStatement().executeUpdate("INSERT INTO studentData (name, id) VALUES ('" + student.getName() + "', " + student.getId() + ");");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("insert into studentdata values(?,?)");
            preparedStatement.setString(2,student.getName());
            preparedStatement.setInt(1,student.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();

        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM studentData");
            while (resultSet.next()) {
                Student student = new Student(resultSet.getString("name"), resultSet.getInt("id"));
                studentList.add(student);
            }
            return studentList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

            }



    private void createTable() {
        try {

                String createTableSQL = "CREATE TABLE IF NOT EXISTS studentData (" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "name VARCHAR(255), " +
                        "PRIMARY KEY (id)" +
                        ")";
                connection.createStatement().executeUpdate(createTableSQL);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

            }


 }
