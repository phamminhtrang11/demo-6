package com.example.demo;

public class Human {
    private String fullName;
    private String cccd;
    private int age;

    public Human(String fullName, String cccd, int age) {
        this.fullName = fullName;
        this.cccd = cccd;
        this.age = age;
    }

    // Getters and Setters

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
}


