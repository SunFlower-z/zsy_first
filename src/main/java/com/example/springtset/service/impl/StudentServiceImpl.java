package com.example.springtset.service.impl;

import com.example.springtset.entity.Student;
import com.example.springtset.mapper.StudentMapper;
import com.example.springtset.service.StudentSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentSrvice {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> select() {
        List<Student> students = studentMapper.selectStudentList();
        return students;
    }

    @Override
    public Student selectOne(Student student) {
        Student studentOne = studentMapper.getOne(student);
        return studentOne;
    }

    @Override
    public Student getName(String schoolName) {
        Student student = studentMapper.getMapper(schoolName);
        return student;
    }
}
