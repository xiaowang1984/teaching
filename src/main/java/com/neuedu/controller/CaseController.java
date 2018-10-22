package com.neuedu.controller;

import com.github.pagehelper.Page;
import com.neuedu.message.Message;
import com.neuedu.pojo.Cases;
import com.neuedu.pojo.Result;
import com.neuedu.service.cases.IcaseService;
import com.neuedu.service.point.IpointService;
import org.apache.ibatis.annotations.Case;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/cases")
public class CaseController {
    @Resource
    IcaseService caseService;
    @Resource
    IpointService pointService;
    @PostMapping("/add")
    public Message add(Cases cases){
        return new Message(caseService.add(cases));
    }
    @GetMapping("/list")
    public Result list(Cases cases){
        List<Cases> list = caseService.list(cases);
        if(list instanceof Page)
            return new Result(list,((Page<Cases>)list).getPages(),((Page<Cases>)list).getPageNum());
        else
            return new Result(list,1,1);
    }
    @GetMapping("/edit")
    public Cases getConseById(int id){
        return  caseService.getCaseById(id);
    }
    @PostMapping("/edit")
    public Message update(Cases cases){
        return new Message(caseService.update(cases));
    }
    @PostMapping("/del")
    public Message del(Cases cases){
        return new Message(caseService.update(cases));
    }
    @GetMapping("/init")
    public Cases init(){
        return new Cases();
    }
}
