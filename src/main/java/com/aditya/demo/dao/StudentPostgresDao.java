package com.aditya.demo.dao;

import com.aditya.demo.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

@Repository("postgres")
public class StudentPostgresDao implements StudentDao{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public StudentPostgresDao(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject=new JdbcTemplate(this.dataSource);
    }

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        String SQL = "insert into Student ( id, age, firstName, lastName, course) values (?, ?, ?, ?, ?)";
        jdbcTemplateObject.update(SQL,
                student.getId(),
                student.getAge(),
                student.getFirstName(),
                student.getLastName(),
                student.getCourse());

        return 1;
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        String SQL = "select * from Student where id = ?";
        Student student = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{studentId}, new StudentMapper());
        return student;
    }

    @Override
    public List<Student> selectAllStudents() {
        String SQL = "select * from Student";
        List <Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
        return students;
    }

    @Override
    public int updateStudentById(UUID studentId, Student studentUpdate) {
        String SQL = "update Student set age = ? , firstName = ?, lastName = ?, course = ? where id = ?";
        jdbcTemplateObject.update(SQL,
                studentUpdate.getAge(),
                studentUpdate.getFirstName(),
                studentUpdate.getLastName(),
                studentUpdate.getCourse(),
                studentId
                );
        System.out.println("Updated Record with ID = " + studentId);
        return 1;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        String SQL = "delete from Student where id = ?";
        jdbcTemplateObject.update(SQL, studentId);
        System.out.println("Deleted Record with ID = " + studentId);
        return 1;
    }


}
