package com.neuedu.controller;

import com.github.pagehelper.Page;
import com.neuedu.pojo.Grade;
import com.neuedu.pojo.Result;
import com.neuedu.service.grade.IgradeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {
    @Resource
    IgradeService gradeService;

    @GetMapping("/list")
    public Result list(Grade grade){
        List<Grade> list = gradeService.list(grade);
        return new Result(list,((Page<Grade>)list).getPages(),((Page<Grade>)list).getPageNum());
    }
}
