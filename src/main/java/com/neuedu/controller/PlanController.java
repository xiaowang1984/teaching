package com.neuedu.controller;


import com.neuedu.message.Message;
import com.neuedu.pojo.Plan;
import com.neuedu.service.plan.IplanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/plan")
public class PlanController {
    @Resource
    IplanService planService;
    @GetMapping("/list")
    public List<Plan> list(Plan plan){
        return planService.getPlans(plan);
    }
    @PostMapping("/add")
    public Message add(Plan plan){
        return  new Message(planService.add(plan));
    }
    @PostMapping("/update")
    public Message update(Plan plan){
        return new Message(planService.edit(plan));
    }
}
