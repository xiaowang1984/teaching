package com.neuedu.controller;

import com.neuedu.pojo.Talk;
import com.neuedu.service.talk.ItalkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/talk")
public class TalkController {
    @Resource
    ItalkService talkService;
    @GetMapping("/details")
    public List<Talk> details(Talk talk){
        return talkService.getDetails(talk);
    }
}
