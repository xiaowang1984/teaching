package com.neuedu.controller;

import com.github.pagehelper.Page;
import com.neuedu.message.Message;
import com.neuedu.pojo.Job;
import com.neuedu.pojo.Result;
import com.neuedu.service.job.IjobService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    @Resource
    IjobService jobService;

    /*获取所有岗位名称，并分页*/
    @GetMapping("/list")
    public Result list(Job job) {
        List<Job> jobs = jobService.getJobs(job);
        if (jobs instanceof Page)
            return new Result(jobs, ((Page<Job>) jobs).getPages(), ((Page<Job>) jobs).getPageNum());
        else
            return new Result(jobs, 1, 1);
    }

    @GetMapping("/edit")
    public Job getJobById(Integer id) {
        return jobService.getJobById(id);
    }

    @PostMapping("/add")
    public Message add(Job job) {
        return new Message(jobService.add(job));
    }

    @PostMapping("/edit")
    public Message update(Job job) {
        return new Message(jobService.update(job));
    }
}
