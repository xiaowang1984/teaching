package com.neuedu.service.job;

import com.github.pagehelper.PageHelper;
import com.neuedu.dao.JobMapper;
import com.neuedu.pojo.Job;
import com.neuedu.pojo.JobExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JobServiceImpl implements IjobService {
    @Resource
    JobMapper jobMapper;

    @Override
    public List<Job> getJobs(Job job) {
        JobExample jobExample = new JobExample();
        if(job.getIsDel()!=null)
            jobExample.createCriteria().andIsDelEqualTo(job.getIsDel());
        if(job.getWithPage()==1)
            PageHelper.startPage(job.getPageNo(),job.getPageSize() );
        return jobMapper.selectByExample(jobExample);
    }

    @Override
    public Job getJobById(Integer id) {
        return jobMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(Job job) {
        return jobMapper.insertSelective(job);
    }

    @Override
    public int update(Job job) {
        return jobMapper.updateByPrimaryKeySelective(job);
    }
}
