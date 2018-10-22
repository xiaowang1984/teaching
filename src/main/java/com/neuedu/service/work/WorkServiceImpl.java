package com.neuedu.service.work;

import com.github.pagehelper.PageHelper;
import com.neuedu.dao.WorkMapper;
import com.neuedu.pojo.Work;
import com.neuedu.pojo.WorkExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class WorkServiceImpl implements IworkService{
    @Resource
    WorkMapper workMapper;

    @Override
    public List<Work> list(Work work,Date dat) {
        WorkExample workExample = new WorkExample();
        workExample.setOrderByClause("id desc");
        WorkExample.Criteria criteria = workExample.createCriteria();
        if(StringUtils.isNotBlank(work.getName()))
            criteria.andNameLike("%"+work.getName()+"%");
        if(StringUtils.isNotBlank(work.getExtend()))
            criteria.andNameLike("%"+work.getExtend()+"%");
        if(dat!=null)
            criteria.andStartDatLessThanOrEqualTo(dat).andEndDatGreaterThanOrEqualTo(dat);
        if(work.getIsDel()!=null)
            criteria.andIsDelEqualTo(work.getIsDel());
        if(work.getGid()!=null)
        criteria.andGidEqualTo(work.getGid());
        if(work.getWithPage()==1)
            PageHelper.startPage(work.getPageNo(), work.getPageSize());
        return workMapper.selectByExampleWithBLOBs(workExample);
    }

    @Override
    public int add(Work work) {
        return workMapper.insertSelective(work);
    }

    @Override
    public int update(Work work) {
        return workMapper.updateByPrimaryKeySelective(work);
    }

    @Override
    public Work getWorkById(int id) {
        return workMapper.selectByPrimaryKey(id);
    }
}
