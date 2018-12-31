package com.aditya.demo.controller;

import com.aditya.demo.model.Student;
import com.aditya.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertNew(@RequestBody Student student) {
        studentService.persistNewStudent(UUID.randomUUID(), student);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "{studentId}")
    public Student getStudentById(@PathVariable("studentId") UUID studentId) {
        return studentService.getStudentById(studentId);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") UUID studentId, @RequestBody Student student) {
        studentService.updateStudentById(studentId, student);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") UUID studentId) {
        studentService.deleteStudentById(studentId);
    }

}
