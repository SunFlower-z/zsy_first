package com.example.springtset.mapper;

import com.example.springtset.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> selectStudentList();

    @Select("select * from user where name = #{name}")
    Student getOne(Student student);

    @Select("select * from  user where school_name = #{schoolName} ")
    Student getMapper(String schoolName);

}
