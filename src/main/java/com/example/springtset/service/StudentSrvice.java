package com.example.springtset.service;

import com.example.springtset.entity.Student;

import java.util.List;

public interface StudentSrvice {
    List<Student> select();

    //查询一个学生信息
    Student selectOne(Student student);

    //通过学校查询到学生
    Student getName(String schoolName);
}
