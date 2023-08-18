package com.example.springtset.controller;

import com.example.springtset.SpringTsetApplication;
import com.example.springtset.entity.Student;
import com.example.springtset.mapper.StudentMapper;
import com.example.springtset.service.StudentSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentContropller {
    @Autowired
    private StudentSrvice studentSrvice;
    @Autowired
    private StudentMapper sm;
    @GetMapping("/selectAll")
    public String selectAll(){
        List<Student> students = studentSrvice.select();
        return students.toString();
    }
    @PostMapping("/selectOneStudent")
    public String selectOneStudent(@RequestBody Student student){
        Student student1 = sm.getOne(student);
        return student1.toString();
    }

    @GetMapping("/selectOneStudent1")
    public String selectOneStudent1(@RequestParam("schoolName") String schoolName){
        if (schoolName == null){
            return "不能为空";
        }
        Student student = studentSrvice.getName(schoolName);
        if (student != null){
            return student.toString();
        }else {
            return"暂无学生信息";
        }
    }
}
