package com.helper.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.helper.model.Student;

@Mapper
public interface StudentMapper {
    List<Student> findAllStudents();
    void insertStudent(Student student);
}
