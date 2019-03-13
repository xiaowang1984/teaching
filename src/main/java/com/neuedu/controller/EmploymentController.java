package com.neuedu.controller;

import com.neuedu.message.Message;
import com.neuedu.pojo.Employment;
import com.neuedu.pojo.EmploymentParams;
import com.neuedu.pojo.Student;
import com.neuedu.service.employment.IemploymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employment")
public class EmploymentController {
    @Resource
    IemploymentService employmentService;
    @PostMapping("/add")
    public Message add(Employment employment, HttpSession session){
        Student student = (Student) session.getAttribute("user");
        employment.setsId(student.getId());
        return  new Message(employmentService.add(employment));
    }
    @GetMapping("/list")
    public List<Employment> list(HttpSession session){
        Student student = (Student)session.getAttribute("user");
        return employmentService.list(student.getId());
    }
    @GetMapping("/edit")
    public Employment getEmployment(Integer id){
        return employmentService.getEmploymentById(id);
    }
    @PostMapping("/edit")
    public Message update(Employment employment){
        return new Message(employmentService.update(employment));
    }
    @GetMapping("/check")
    public Message check(Employment employment){
        return new Message(employmentService.check(employment));
    }
    @GetMapping("/reportByGrade")
    public List<Map<String, Object>> reportByGrade(EmploymentParams params) {
        return employmentService.reportByGrade(params);
    }
    @GetMapping("/reportByStudent")
    public List<Map<String, Object>> reportByStudent(Integer sId) {
        return employmentService.reportByStudent(sId);
    }
}
