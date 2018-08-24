package com.neuedu.controller;

import com.neuedu.pojo.Student;
import com.neuedu.service.student.IstudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    IstudentService studentService;
    @GetMapping("/list")
    public Map list(Student student){
        return studentService.list(student);
    }
}
