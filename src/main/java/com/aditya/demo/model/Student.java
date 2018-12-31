package com.aditya.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Student {
    private UUID id;
    private Integer age;
    private String firstName;
    private String lastName;
    private String course;

    public Student(){

    }

    public Student(
           @JsonProperty("id") UUID id,
           @JsonProperty("age") Integer age,
           @JsonProperty("firstName") String firstName,
           @JsonProperty("lastName") String lastName,
           @JsonProperty("course") String course) {
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }



    public UUID getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
