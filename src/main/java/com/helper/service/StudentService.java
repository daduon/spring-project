package com.helper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.helper.checkResponse.BaseRest;
import com.helper.checkResponse.BaseRestFactory;
import com.helper.mapper.StudentMapper;
import com.helper.model.Student;

@Service
public class StudentService {
    private final StudentMapper studentMapper;
    
    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public BaseRest<List<Student>> getStudentList() {
        return BaseRestFactory.success(studentMapper.findAllStudents());
    }

    public BaseRest<Student> insertStudent(Student student) {
        studentMapper.insertStudent(student);
        return BaseRestFactory.success(student);
    }
}
