package com.neuedu.controller;

import com.github.pagehelper.Page;
import com.neuedu.pojo.Grade;
import com.neuedu.pojo.Result;
import com.neuedu.pojo.Teacher;
import com.neuedu.service.grade.IgradeService;
import com.neuedu.service.report.IreportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {
    @Resource
    IgradeService gradeService;
    @Resource
    IreportService reportService;

    @GetMapping("/list")
    public Result list(Grade grade, HttpSession session){
        Teacher teacher = (Teacher)session.getAttribute("user");
        if(!teacher.getNo().equals("admin")) {
            if (teacher.getType() == 1)
                grade.setLecturer(teacher.getId());
            else if (teacher.getType() == 0)
                grade.setManager(teacher.getId());
            else
                return new Result(new ArrayList<Grade>(),0,0);
        }
        List<Grade> list = gradeService.list(grade);
        return new Result(list,((Page<Grade>)list).getPages(),((Page<Grade>)list).getPageNum());
    }
    @GetMapping("/logs")
    public Result logs(Integer gId){
        return new Result(reportService.getMooddaysByGid(gId), 0, 0);
    }
}
