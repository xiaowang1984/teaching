package com.neuedu.controller;

import com.neuedu.pojo.Moodday;
import com.neuedu.pojo.Workgrade;
import com.neuedu.service.report.IreportService;
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
    @GetMapping("/all")
    public Map<String,Object> getAll(Moodday moodday){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(moodday.getDat());
        calendar.add(Calendar.DATE, 6);
        Date end = calendar.getTime();
        Map<String,Object> result=new HashMap<>();
        List<Moodday> thisMoodday=reportService.getMooddays(moodday,end);
        List<Workgrade> thisWorkGrade=workGradeService.workReport(moodday.getGrade(), moodday.getDat(), end);
        result.put("thismood", thisMoodday);
        result.put("thisWorkGrade", thisWorkGrade);
        return result;
    }
}
