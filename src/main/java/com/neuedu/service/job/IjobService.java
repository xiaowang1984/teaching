package com.neuedu.service.job;

import com.neuedu.pojo.Job;

import java.util.List;

public interface IjobService {
    List<Job> getJobs(Job job);
    Job getJobById(Integer id);
    int add(Job job);
    int update(Job job);
}
