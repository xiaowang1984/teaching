package com.neuedu.controller;

import com.neuedu.pojo.Arrange;
import com.neuedu.pojo.Grade;
import com.neuedu.service.arrange.IarrangeService;
import com.neuedu.service.grade.IgradeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Resource
    IgradeService gradeService;
    @GetMapping("/list")
    public Grade list(int gId){
        return gradeService.board(gId);
    }
}
