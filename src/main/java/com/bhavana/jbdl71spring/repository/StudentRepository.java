package com.bhavana.jbdl71spring.repository;

import com.bhavana.jbdl71spring.model.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    public StudentRepository() {
        createTable();
    }


    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentDetails", "root", "root");
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM studentData");
            while (resultSet.next()) {
                Student student = new Student(resultSet.getString("name"), resultSet.getInt("id"));
                studentList.add(student);
            }
            return studentList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void createTable() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentDetails", "root", "root");
            try {
                String createTableSQL = "CREATE TABLE IF NOT EXISTS studentData (" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "name VARCHAR(255), " +
                        "PRIMARY KEY (id)" +
                        ")";
                connection.createStatement().executeUpdate(createTableSQL);
            } catch (SQLException e) {
                System.out.println("oh no");
                throw new RuntimeException(e);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
