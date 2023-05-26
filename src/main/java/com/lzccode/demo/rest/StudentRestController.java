package com.lzccode.demo.rest;


import com.lzccode.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define endpoint for /students-- return all students

    @GetMapping("/students")
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Smith", "John"));
        students.add(new Student("Mary", "Zuick"));
        students.add(new Student("qxc", "Ted"));

        return students;
    }


}
