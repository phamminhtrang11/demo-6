package com.example.demo;

public class Student extends Human {
        private int id;
        private String grade;
        private String className;

        public Student(String fullName, String CCCD, int age, int id, String grade, String className) {
            super(fullName, CCCD, age);
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

    public void setName(String grade) {
        this.grade = grade;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
