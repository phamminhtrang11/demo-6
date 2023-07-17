package com.example.demo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
public class StudentController {
    private List<Student> students = new ArrayList<>();
    @Autowired
    public StudentRepo TheRepo;
    private Logger logger = Logger.getLogger(StudentController.class.getName());

    public StudentController() {
        students.add(new Student("Pham A", "5", 16, 5, "10", "10B"));
        students.add(new Student("Ngoc B", "6", 16, 6, "10", "10A"));
        students.add(new Student("Anh C", "7", 17, 7, "11", "11C"));
        students.add(new Student("Ngoc D", "8", 16, 8, "11", "11B"));
    }

//   @PostMapping(value = "/students")
//    public MyAn getStudentsByClass(@RequestBody RequestStudent requestStudent) {
//        String className = requestStudent.getClassName();
//        MyAn ma = new MyAn();
//        List<Student> studentsByClass = new ArrayList<>();
//
//        if (students == null || students.size() == 0) {
//            ma.setCode("01");
//            ma.setMessage("Ko tim thay");
//            ma.setLstStudent(studentsByClass);
//            return ma;
//        }
//
//        for (Student student : students) {
//            try {
//                if (student.getClassName().equalsIgnoreCase(className)) {
//                    studentsByClass.add(student);
//                }
//            } catch (Exception ex) {
//                ma.setCode("99");
//                ma.setMessage("gap loi");
//                return ma;
//            }
//        }
//
//        if (studentsByClass.isEmpty()) {
//            ma.setCode("01");
//            ma.setMessage("Ko tim thay");
//        } else {
//            ma.setCode("00");
//            ma.setMessage("Thanh cong");
//        }
//
//        ma.setLstStudent(studentsByClass);
//        return ma;
//    }
@GetMapping("/students_test")
public ResponseEntity<List<Student>> getStudent(){
    try {
        List<Student> res = (List<Student>) TheRepo.findAll();
        logger.log(Level.INFO, "Get students: {0}", res);
        return new ResponseEntity<>(res, HttpStatus.OK);
    } catch (Exception e) {
        logger.log(Level.SEVERE, "Error getting students", e);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
    @GetMapping(value = "/students_with_class")
    public ResponseEntity<List<Student>> getStudent(@RequestBody RequestStudent param){
        try {
            logger.log(Level.INFO, "Get students with class: {0}", param.getClassName());
            List<Student> list = (List<Student>) TheRepo.findAll();
            List<Student> res = new ArrayList<Student>();
            for (Student s: list){
                if (s.getClassName().equals(param.getClassName())){
                    logger.log(Level.INFO, "Found student: {0}", s);
                    res.add(s);
                }
            }
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error getting students by class", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(value="/students_test")
    public ResponseEntity<List<Student>> addStudent(@RequestBody Student param){
        try {
            logger.log(Level.INFO, "Add student: {0}", param);
            TheRepo.save(param);
            List<Student> list = (List<Student>) TheRepo.findAll();
            List<Student> res = new ArrayList<Student>();
            for (Student s: list){
                if (s.getClassName().equals(param.getClassName())){
                    logger.log(Level.INFO, "Found student: {0}", s);
                    res.add(s);
                }
            }
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error adding student", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/students_test")
    public ResponseEntity<List<Student>> editStudent(@RequestBody Student param){
        try {
            List<Student> list = (List<Student>) TheRepo.findAll();
            for (Student s : list){
                if (param.getId()==s.getId()){
                    TheRepo.delete(s);
                    TheRepo.save(param);
                    logger.log(Level.INFO, "Edited student: {0}", param);
                    return new ResponseEntity<>((List<Student>)TheRepo.findAll(), HttpStatus.OK);
                }
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error editing student", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @DeleteMapping(value="/students_test")
//    public ResponseEntity<String> delete(@RequestBody Student param){
//        TheRepo.deleteAll();
//        return new ResponseEntity<>("Deleted all entries",HttpStatus.OK);
//    }


    @DeleteMapping(value="/students_test")
    public ResponseEntity<String> delete(@RequestBody Student param){
        try {
            List<Student> list = (List<Student>) TheRepo.findAll();
            for (Student s : list){
                if (param.getId()==s.getId()){
                    TheRepo.delete(s);
                    logger.log(Level.INFO, "Deleted student: {0}", s.getId());
                    return new ResponseEntity<>("Deleted student " + s.getId(), HttpStatus.OK);
                }
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error deleting student", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}