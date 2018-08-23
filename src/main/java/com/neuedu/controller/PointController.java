package com.neuedu.controller;

import com.neuedu.message.Message;
import com.neuedu.pojo.Point;
import com.neuedu.service.point.IpointService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/point")
public class PointController {
    @Resource
    IpointService pointService;
    @PostMapping("/add")
    public Message add(Point point){
        return new Message(pointService.add(point));
    }
    @GetMapping("/edit")
    public Point getPointById(int id){
        return  pointService.getPointById(id);
    }
    @PostMapping("/edit")
    public Message update(Point point){
        return new Message(pointService.update(point));
    }
    @PostMapping("/del")
    public Message del(Point point){
        point.setIsDel(0);
        return  new Message(pointService.update(point));
    }
}
