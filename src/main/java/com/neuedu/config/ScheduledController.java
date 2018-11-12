package com.neuedu.config;

import com.neuedu.service.workstudent.IworkstudentService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class ScheduledController {
    @Resource
    IworkstudentService workstudentService;
    @Scheduled(cron = "0 0 01 * * ? ")
    public void pushDataScheduled(){
        workstudentService.batchload(new Date());
    }
}
