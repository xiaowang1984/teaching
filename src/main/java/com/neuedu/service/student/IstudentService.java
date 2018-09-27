package com.neuedu.service.student;

import com.neuedu.pojo.Grade;
import com.neuedu.pojo.Student;

import java.util.List;
import java.util.Map;

public interface IstudentService {
    Grade list(Student student);
    int add(Student student);
    Student getStudent(int id);
    int update(Student student);
    int del(int id);
    int  bathUpdate(List<Student> list);
    int count(int gId);
    int offerCount(int gId);
    int checkIdCard(Student student);
}
