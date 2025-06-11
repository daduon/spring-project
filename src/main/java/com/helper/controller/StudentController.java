package com.helper.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helper.checkResponse.BaseRest;
import com.helper.model.Student;
import com.helper.service.StudentService;



@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public ResponseEntity<BaseRest<List<Student>>> getAllStudents() {
        return ResponseEntity.ok(studentService.getStudentList());
    }

    @PostMapping("/create")
    public ResponseEntity<BaseRest<Student>> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.insertStudent(student));
    }
    
}
