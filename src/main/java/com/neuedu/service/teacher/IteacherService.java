package com.neuedu.service.teacher;

import com.neuedu.pojo.Teacher;

import java.util.List;

public interface IteacherService {
    Teacher login(String no);
    List<Teacher> getTeacher(Teacher teacher);
    int add(Teacher teacher);
    Teacher getTeacherById(int id);
    int update(Teacher teacher);
}
