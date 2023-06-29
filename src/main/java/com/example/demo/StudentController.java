package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student("Pham A", "5", 16, 5, "10", "10B"));
        students.add(new Student("Ngoc B", "6", 16, 6, "10", "10A"));
        students.add(new Student("Anh C", "7", 17, 7, "11", "11C"));
        students.add(new Student("Ngoc D", "8", 16, 8, "11", "11B"));
    }

    @PostMapping(value = "/students")
    public MyAn getStudentsByClass(@RequestBody RequestStudent requestStudent) {
        String className = requestStudent.getClassName();
        MyAn ma = new MyAn();
        List<Student> studentsByClass = new ArrayList<>();

        if (students == null || students.size() == 0) {
            ma.setCode("01");
            ma.setMessage("Ko tim thay");
            ma.setLstStudent(studentsByClass);
            return ma;
        }

        for (Student student : students) {
            try {
                if (student.getClassName().equalsIgnoreCase(className)) {
                    studentsByClass.add(student);
                }
            } catch (Exception ex) {
                ma.setCode("99");
                ma.setMessage("gap loi");
                return ma;
            }
        }

        if (studentsByClass.isEmpty()) {
            ma.setCode("01");
            ma.setMessage("Ko tim thay");
        } else {
            ma.setCode("00");
            ma.setMessage("Thanh cong");
        }

        ma.setLstStudent(studentsByClass);
        return ma;
    }
}
