package com.example.demo.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hocsinh")
public class Student{
    public Student(){}
    @Column(name = "fullname")
    private String fullName;
    @Column(name="cccd")
    private String cccd;
    @Column(name="age")
    private int age;
    @Id
    @Column(name="id")
    private int id;
    @Column(name="grade")
    private String grade;
    @Column(name="classname")
    private String className;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Student(String fullName, String CCCD, int age, int id, String grade, String className) {
            this.fullName = fullName;
            this.cccd = cccd;
            this.age = age;

            this.id = id;
            this.grade = grade;
            this.className = className;
        }

        // Getters and Setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    public String getGrade() {
        return grade;
    }



    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
