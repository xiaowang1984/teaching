package com.neuedu.controller;

import com.neuedu.core.DESUtils;
import com.neuedu.core.MyUtils;
import com.neuedu.message.Message;
import com.neuedu.pojo.Student;
import com.neuedu.pojo.Teacher;
import com.neuedu.service.student.IstudentService;
import com.neuedu.service.teacher.IteacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Resource
    IteacherService teacherService;
    @Resource
    IstudentService studentService;
    @PostMapping("/login")
    public Message getTeachers(Teacher teacherQuery,HttpSession session){
        Teacher teacher=teacherService.login(teacherQuery.getNo());
        if(teacher==null)
            return new Message(0,"用户名不存在");
        else{
            if(teacher.getPassword().equals(DESUtils.getEncryptString(teacherQuery.getPassword()))) {
               session.setAttribute("user", teacher);
                return new Message(1, "登录成功");
            }else
                return new Message(0,"密码错误");
        }
    }
    @GetMapping("/logUser")
    public Teacher teacher(HttpSession session){
        Teacher teacher=(Teacher)session.getAttribute("user");
        return  teacher;
    }
    @GetMapping("/exit")
    public void exit(HttpSession session){
        if(session.getAttribute("user")!=null)
            session.removeAttribute("user");
    }
    @GetMapping("/checkpwd")
    public Map<String,String> checkpwd(Teacher teacherQuery){
        Map<String,String> map=new HashMap<>();
        Teacher teacher=teacherService.login(teacherQuery.getNo());
        if(teacher!=null){
            if(teacher.getPassword().equals(DESUtils.getEncryptString(teacherQuery.getPassword()))){
                map.put("getdata","true");
            }
        }
        return map;
    }

    @GetMapping("/checkstupwd")
    public Map<String,String> checkstupwd(String password,HttpSession session){
        Map<String,String> map=new HashMap<>();
        Student student = (Student) session.getAttribute("user");
        Student stu=studentService.getStudent(student.getId());
        if(student!=null){
            if(stu.getPwd().equals(DESUtils.getEncryptString(password))){
                map.put("getdata","true");
            }
        }
        return map;
    }

    @PostMapping("/changeStuPwd")
    public Message changeStuPwd(String password,HttpSession session ){
        Student student = (Student) session.getAttribute("user");
        Student stu = new Student();
        stu.setPwd(DESUtils.getEncryptString(password));
        stu.setId(student.getId());
        return new Message(studentService.update(stu), "密码修改完成");
    }
}
