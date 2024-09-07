package com.prashant.springbootrestcrud.rest;

import com.prashant.springbootrestcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Rohan","Shetty"));
        students.add(new Student("John","Doe"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if((studentId > students.size()) || studentId < 0){
            throw new StudentNotFoundException("Student not found with id : " + studentId);
        }
        Student student = students.get(studentId);
        return student;
    }

}
