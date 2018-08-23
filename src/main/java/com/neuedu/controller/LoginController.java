package com.neuedu.controller;

import com.neuedu.core.DESUtils;
import com.neuedu.message.Message;
import com.neuedu.pojo.Teacher;
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
}
