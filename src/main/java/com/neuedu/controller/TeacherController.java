package com.neuedu.controller;

import com.github.pagehelper.Page;
import com.neuedu.core.DESUtils;
import com.neuedu.message.Message;
import com.neuedu.pojo.Result;
import com.neuedu.pojo.Teacher;
import com.neuedu.service.teacher.IteacherService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Resource
    IteacherService teacherService;
    @GetMapping("/list")
    public Result list(Teacher teacher){
        List<Teacher> teachers=teacherService.getTeacher(teacher);
        if(teachers instanceof Page){
            return new Result(teachers,((Page<Teacher>)teachers).getPages(),((Page<Teacher>)teachers).getPageNum());
        }else{
            return new Result(teachers,1,1);
        }

    }
    @GetMapping("/listforgrade")
    public List<Teacher> listforgrade(Teacher teacher){
        return teacherService.getTeacher(teacher);
    }
    @PostMapping("/add")
    public Message add(Teacher teacher){
        teacher.setPassword(DESUtils.getEncryptString(teacher.getPassword()));
        return new Message(teacherService.add(teacher),"添加成功");
    }
    @GetMapping("/edit")
    public Teacher getEdit(int id){
       return teacherService.getTeacherById(id);
    }
    @PostMapping("/edit")
    public Message update(Teacher teacher){
        if(StringUtils.isNotBlank(teacher.getPassword()))
            teacher.setPassword(DESUtils.getEncryptString(teacher.getPassword()));
        return new Message(teacherService.update(teacher),"修改成功");
    }
    @PostMapping("/isDel")
    public Message isDel(Teacher teacher){
        if(teacher.getIsDel()==0)
            return new Message(teacherService.update(teacher),"离职完成");
        else
            return new Message(teacherService.update(teacher),"离职恢复");
    }
}
