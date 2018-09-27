package com.neuedu.controller;

import com.neuedu.message.Message;
import com.neuedu.pojo.Arrange;
import com.neuedu.service.arrange.IarrangeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;


@RestController
@RequestMapping("/arrange")
public class ArrangeController {
    @Resource
    IarrangeService arrangeService;

    @PostMapping("/add")
    public Message add(Arrange arrange,Date[] dates){
        return new Message(arrangeService.add(arrange, dates));
    }
    @GetMapping("/getArrange")
    public Arrange getArrange(int aId){
        return arrangeService.getArrangeById(aId);
    }
    @PostMapping("/update")
    public Message update(Arrange arrange,Date[] dates){
        return new Message(arrangeService.update(arrange,dates ));
    }
    @GetMapping("/del")
    public Message del(Arrange arrange){
        return new Message(arrangeService.del(arrange));
    }
}
