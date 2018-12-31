package com.aditya.demo.dao;

import com.aditya.demo.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class StudentMapper implements RowMapper<Student> {
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(UUID.fromString(rs.getString("id")));
        student.setAge(rs.getInt("age"));
        student.setFirstName(rs.getString("firstName"));
        student.setLastName(rs.getString("lastName"));
        student.setCourse(rs.getString("course"));
        return student;
    }
}