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

    /*获取所有岗位名称，并分页*/
    @Override
    public List<Job> getJobs(Job job) {
        JobExample jobExample = new JobExample();

        //如果岗位有效标记不是空
        if (job.getIsDel() != null)
            /*这里的作用是？*/
            //获取不同类型的岗位
            jobExample.createCriteria().andIsDelEqualTo(job.getIsDel()).andIs_TypeEqualTo(job.getIs_type());

        if (job.getWithPage() == 1)
            PageHelper.startPage(job.getPageNo(), job.getPageSize());
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
