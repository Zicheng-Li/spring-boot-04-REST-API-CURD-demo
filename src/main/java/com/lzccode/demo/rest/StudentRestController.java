package com.lzccode.demo.rest;


import com.lzccode.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loaddate() {
        students = new ArrayList<>();

        students.add(new Student("Smith", "John"));
        students.add(new Student("Mary", "Zuick"));
        students.add(new Student("qxc", "Ted"));

    }

    // define endpoint for /students-- return all students

    @GetMapping("/students")
    public List<Student> getAllStudents() {

        return students;
    }

    // define endpoint for /students/{studentId}-- return a single student

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable("studentId") int studentId) {  // by default, variables name should match

        // check the student id against list size
        if((studentId >= students.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("student id not found" + studentId);
        }

        return students.get(studentId);
    }


}
