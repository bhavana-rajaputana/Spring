package com.bhavana.jbdl71spring;

import com.bhavana.jbdl71spring.model.Student;
import com.zaxxer.hikari.util.DriverDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
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
//    @Bean
//   public DataSource getDataSource() {
//        DriverManagerDataSource datasource =new DriverManagerDataSource();
//        //datasource.setDriverClassName("com.mysql.jdbc.Driver");
//        datasource.setUrl("jdbc:mysql://localhost:3306/studentDetails");
//        datasource.setUsername("root");
//        datasource.setPassword("root");
//        return datasource;
//    }

}


