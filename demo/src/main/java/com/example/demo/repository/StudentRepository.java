package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    static List<Student> studentList=new ArrayList<>();
    static {
        studentList.add(new Student(1,"Hi"));
        studentList.add(new Student(2,"Vi"));
        studentList.add(new Student(3,"Li"));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }
}
