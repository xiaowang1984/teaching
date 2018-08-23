package com.neuedu.controller;

import com.neuedu.core.MyUtils;
import com.neuedu.message.Message;
import com.neuedu.pojo.Course;
import com.neuedu.service.course.IcourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Resource
    IcourseService courseService;
    @GetMapping("/list")
    public List<Course> list(Course course){
        return courseService.getCourse(course);
    }
    @PostMapping("/add")
    public Message add(Course course,MultipartFile logo){
        Message message;
        try {
            String img=MyUtils.fileUpload(logo);
            course.setImg(img);
            message=new Message(courseService.add(course));
        } catch (Exception e) {
            message=new Message(0);
            e.printStackTrace();
        }
        return message;
    }

    @GetMapping("/edit")
    public Course getCourseById(int id){
        return courseService.getCourseById(id);
    }
    @PostMapping("/edit")
    public Message update(Course course,MultipartFile logo){
        Message message;
        try {
            if(logo!=null){
                String img=MyUtils.fileUpload(logo);
                course.setImg(img);
            }
            message=new Message(courseService.edit(course));
        } catch (Exception e) {
            message=new Message(0);
            e.printStackTrace();
        }
        return message;
    }

}
