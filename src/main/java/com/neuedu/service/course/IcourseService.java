package com.neuedu.service.course;

import com.neuedu.pojo.Course;

import java.util.List;

public interface IcourseService {
    List<Course> getCourse(Course course);
    int add(Course course);
    int edit(Course course);
    Course getCourseById(int id);
}
