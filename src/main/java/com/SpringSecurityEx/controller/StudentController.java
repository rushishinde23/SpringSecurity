package com.SpringSecurityEx.controller;


import com.SpringSecurityEx.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class StudentController {

    List<Student> students=new ArrayList<>(List.of(
            new Student(1,"rushi",23),
            new Student(2,"angad",25)
    ));

    @GetMapping("/")
    public String sayHello(HttpServletRequest request){
        return "Hello, we are using spring security"+request.getSession().getId();
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return students;
    }

    @PostMapping("students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }

    @GetMapping("/csrf")
    public CsrfToken getTocken(HttpServletRequest request){
        System.out.println((CsrfToken) request.getAttribute("_csrf"));
        return (CsrfToken) request.getAttribute("_csrf");
    }


}
