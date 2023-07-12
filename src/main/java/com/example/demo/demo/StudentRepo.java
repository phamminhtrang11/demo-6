package com.example.demo.demo;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student,String> {
}
