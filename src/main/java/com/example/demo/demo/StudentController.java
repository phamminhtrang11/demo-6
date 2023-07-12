package com.example.demo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> students = new ArrayList<>();
    @Autowired
    public StudentRepo TheRepo;

    public StudentController() {
        students.add(new Student("Pham A", "5", 16, 5, "10", "10B"));
        students.add(new Student("Ngoc B", "6", 16, 6, "10", "10A"));
        students.add(new Student("Anh C", "7", 17, 7, "11", "11C"));
        students.add(new Student("Ngoc D", "8", 16, 8, "11", "11B"));
    }

//    @PostMapping(value = "/students")
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
        List<Student> res = (List<Student>) TheRepo.findAll();
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    @GetMapping(value = "/students_with_class")
    public ResponseEntity<List<Student>> getStudent(@RequestBody RequestStudent param){
        System.out.println(param.getClassName());
        List<Student> list = (List<Student>) TheRepo.findAll();
        List<Student> res = new ArrayList<Student>();
        for (Student s: list){
            if (s.getClassName().equals(param.getClassName())){
                System.out.println(s);
                res.add(s);
            }
        }
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

        @PostMapping(value="/students_test")
        public ResponseEntity<List<Student>> addStudent(@RequestBody Student param){

            TheRepo.save(param);
            List<Student> list = (List<Student>) TheRepo.findAll();
            List<Student> res = new ArrayList<Student>();
            for (Student s: list){
                if (s.getClassName().equals(param.getClassName())){
                    System.out.println(s);
                    res.add(s);
                }
            }
            return new ResponseEntity<>(res,HttpStatus.OK);

    }

    @PutMapping(value="/students_test")
    public ResponseEntity<List<Student>> editStudent(@RequestBody Student param){
        List<Student> list = (List<Student>)
                TheRepo.findAll();
        for (Student s : list){
            if (param.getId()==s.getId()){
                TheRepo.delete(s);
                TheRepo.save(param);
                return new ResponseEntity<>((List<Student>)TheRepo.findAll(),HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null);
    }
//    @DeleteMapping(value="/students_test")
//    public ResponseEntity<String> delete(@RequestBody Student param){
//        TheRepo.deleteAll();
//        return new ResponseEntity<>("Deleted all entries",HttpStatus.OK);
//    }


    @DeleteMapping(value="/students_test")
    public ResponseEntity<String> delete(@RequestBody Student param){
        List<Student> list = (List<Student>)
                TheRepo.findAll();
        for (Student s : list){
            if (param.getId()==s.getId()){
                TheRepo.delete(s);
                //TheRepo.save(param);
                return new ResponseEntity<>("Deleted student "+s.getId() ,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null);
    }
}
