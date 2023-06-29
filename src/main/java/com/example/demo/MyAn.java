package com.example.demo;

import java.util.List;

public class MyAn {
    private String code;
    private String message;

    public List<Student> getLstStudent() {
        return lstStudent;
    }

    public void setLstStudent(List<Student> lstStudent) {
        this.lstStudent = lstStudent;
    }

    List<Student> lstStudent;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
