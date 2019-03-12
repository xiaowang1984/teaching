package com.neuedu.controller;

import com.neuedu.message.Message;
import com.neuedu.pojo.Interview;
import com.neuedu.pojo.InterviewDetails;
import com.neuedu.pojo.Student;
import com.neuedu.service.interview.InterviewService;
import com.neuedu.service.interviewDetails.InterviewDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/interView")
public class InterViewController {
    @Resource
    InterviewService interviewService;
    @Resource
    InterviewDetailsService interviewDetailsService;
    @GetMapping("/list")
    public List<Interview> list(int gId){
        return interviewService.list(gId);
    }
    @PostMapping("/detailsave")
    public Message detailsave(InterviewDetails interviewDetails){
        return new Message(interviewDetailsService.save(interviewDetails));
    }
    @PostMapping("/add")
    public Message add(Interview interview){
        return new Message(interviewService.add(interview));
    }

    @PostMapping("/update")
    public Message update(Interview interview){
        return new Message(interviewService.update(interview));
    }

    @GetMapping("/stuinterview")
    public List<InterviewDetails> stuinterview(HttpSession session){
        Student student = (Student)session.getAttribute("user");
        return interviewDetailsService.getInterviewDetailsBySid(student.getId());
    }
}
