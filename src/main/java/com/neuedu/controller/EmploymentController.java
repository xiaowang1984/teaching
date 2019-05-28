package com.neuedu.controller;

import com.neuedu.common.ServerResponse;
import com.neuedu.message.Message;
import com.neuedu.pojo.Employment;
import com.neuedu.pojo.EmploymentParams;
import com.neuedu.pojo.Student;
import com.neuedu.service.employment.IemploymentService;
import com.neuedu.vo.ParmaVOAll;
import com.neuedu.vo.ParmaVODetil;
import org.springframework.web.bind.annotation.*;

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
    public Message add(Employment employment, HttpSession session) {
        Student student = (Student) session.getAttribute("user");
        employment.setsId(student.getId());
        return new Message(employmentService.add(employment));
    }

    /*根据学生id获取该学生的所有就业数据*/
    @GetMapping("/list")
    public List<Employment> list(HttpSession session) {
        Student student = (Student) session.getAttribute("user");
        return employmentService.list(student.getId());
    }

    @GetMapping("/edit")
    public Employment getEmployment(Integer id) {
        return employmentService.getEmploymentById(id);
    }

    /*学生更新就业数据*/
    @PostMapping("/edit")
    public Message update(Employment employment) {
        return new Message(employmentService.update(employment));
    }

    @GetMapping("/check")
    public Message check(Employment employment) {
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


    /*==========================zhangxin=============================*/

    /**
     * @根据不同参数获取就业信息数据，以公司分类
     */
    @RequestMapping("/joblist")
    public ServerResponse getJoblist(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        ServerResponse sr = employmentService.getJoblist(pageNum, pageSize);
        return sr;
    }

    /**
     * @根据公司名称获取就业信息数据
     */
    @RequestMapping("/joblistCname")
    public ServerResponse getJoblistCname(String c_name) {
        ServerResponse sr = employmentService.getJoblistCname(c_name);
        return sr;
    }

    /**
     * @根据不同参数获取详细就业信息数据
     */
    @RequestMapping("/joblistdetil")
    public ServerResponse joblistdetil(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                       @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                       ParmaVODetil p) {
        ServerResponse sr = employmentService.getJoblistDetil(pageNum, pageSize, p);
        return sr;
    }

    /**
     * @根据班级id获取该班级有offer的人数（一个人有多个offer只计算一次）
     */
    @RequestMapping("/classonum")
    public ServerResponse classonum(Integer gid) {
        ServerResponse sr = employmentService.getClassONum(gid);
        return sr;
    }
}
