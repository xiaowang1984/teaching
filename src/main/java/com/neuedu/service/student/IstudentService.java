package com.neuedu.service.student;

import com.neuedu.pojo.Grade;
import com.neuedu.pojo.Student;

import java.util.Date;
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
    List<Student> getStudentsByGid(int gId);
    Student getStudentByGit(String git);
    List<Student> getStudentWork(int gId,  int wId);
    Student login(String loginId);
    int studentcount(int gId);
    int changepwd(Student student);
}
