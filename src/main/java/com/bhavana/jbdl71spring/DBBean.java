package com.bhavana.jbdl71spring;

import com.bhavana.jbdl71spring.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class DBBean {
    @Bean
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentDetails", "root", "root");

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
return connection;
    }
}


