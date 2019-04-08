package com.neuedu.service.job;

import com.neuedu.pojo.Job;

import java.util.List;

public interface IjobService {
    /*获取所有岗位名称，并分页*/
    List<Job> getJobs(Job job);

    Job getJobById(Integer id);

    int add(Job job);

    int update(Job job);
}
