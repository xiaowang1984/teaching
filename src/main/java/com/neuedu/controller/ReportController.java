package com.neuedu.controller;

import com.neuedu.pojo.*;
import com.neuedu.service.interview.InterviewService;
import com.neuedu.service.meeting.ImeetingService;
import com.neuedu.service.report.IreportService;
import com.neuedu.service.student.IstudentService;
import com.neuedu.service.talk.ItalkService;
import com.neuedu.service.workgrade.IworkGradeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/report")
public class ReportController  {
    @Resource
    IreportService reportService;
    @Resource
    IworkGradeService workGradeService;
    @Resource
    InterviewService interviewService;
    @Resource
    ItalkService talkService;
    @Resource
    IstudentService studentService;
    @Resource
    ImeetingService meetingService;
    @GetMapping("/all")
    public Map<String,Object> getAll(Moodday moodday){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(moodday.getDat());
        calendar.add(Calendar.DATE, 6);
        Date end = calendar.getTime();
        Map<String,Object> result=new HashMap<>();
        List<Moodday> thisMoodday=reportService.getMooddays(moodday,end);
        List<Workgrade> thisWorkGrade=workGradeService.workReport(moodday.getGrade(), moodday.getDat(), end);
        List<Interview> interview = interviewService.list(moodday.getGrade());
        List<Talk> talks = talkService.getReport(moodday.getGrade());
        int studentcount=studentService.studentcount(moodday.getGrade());
        List<Meeting> meetings = meetingService.getMeeting(moodday.getGrade());
        result.put("thismood", thisMoodday);
        result.put("thisWorkGrade", thisWorkGrade);
        result.put("interview", interview);
        result.put("talks", talks);
        result.put("studentcount", studentcount);
        result.put("meetings", meetings);
        return result;
    }
}
