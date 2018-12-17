package com.neuedu.controller;

import com.neuedu.message.Message;
import com.neuedu.pojo.Score;
import com.neuedu.service.score.IscoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Resource
    IscoreService scoreService;
    @GetMapping("/list")
    public List<Score> list(Score score){
        return scoreService.list(score);
    }
    @PostMapping("/save")
    public Message save(Score score){
        return new Message(scoreService.save(score));
    }

}
