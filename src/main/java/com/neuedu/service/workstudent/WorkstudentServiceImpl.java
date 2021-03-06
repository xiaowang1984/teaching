package com.neuedu.service.workstudent;

import com.neuedu.dao.WorkgradeMapper;
import com.neuedu.dao.WorkstudentMapper;
import com.neuedu.pojo.WorkgradeExample;
import com.neuedu.pojo.Workstudent;
import com.neuedu.pojo.WorkstudentExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class WorkstudentServiceImpl implements IworkstudentService{
    @Resource
    WorkstudentMapper workstudentMapper;
    @Resource
    WorkgradeMapper workgradeMapper;
    @Override
    @Transactional
    public int batchload(Date date) {
        int result=0;
        WorkstudentExample workstudentExample = new WorkstudentExample();
        WorkgradeExample workgradeExample = new WorkgradeExample();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        Date prev =  calendar.getTime();
        workstudentExample.createCriteria().andDatEqualTo(prev);
        result += workstudentMapper.deleteByExample(workstudentExample);
        result += workstudentMapper.batchload(prev);
        workgradeExample.createCriteria().andDatEqualTo(prev);
        result += workgradeMapper.deleteByExample(workgradeExample);
        result += workgradeMapper.batchload(prev);
        return result;
    }

    @Override
    public List<Workstudent> list(int wId,int sId) {
        WorkstudentExample workstudentExample = new WorkstudentExample();
        workstudentExample.createCriteria().andWIdEqualTo(wId).andSIdEqualTo(sId);
        workstudentExample.setOrderByClause("dat asc");
        return workstudentMapper.selectByExample(workstudentExample);
    }

    @Override
    public int update(Workstudent workstudent) {
        WorkstudentExample workstudentExample = new WorkstudentExample();
        workstudentExample.createCriteria().andSIdEqualTo(workstudent.getsId()).andWIdEqualTo(workstudent.getwId());
        return workstudentMapper.updateByExampleSelective(workstudent, workstudentExample);
    }

    @Override
    public int checkcount(int wId) {
        return workstudentMapper.checkcount(wId);
    }

    @Override
    public List<Date> getDatesBySid(Integer sId) {
        return workstudentMapper.getDatesBySid(sId);
    }

    @Override
    public List<Map<String, Object>> getStuCode(Integer sId,List<Date> dates) {
        Map<String,Object> params = new HashMap<>();
        params.put("sid", sId);
        params.put("dates", dates);
        return workstudentMapper.getStuCode(params);
    }

    @Override
    public List<Workstudent> donecount(Integer sId) {
        return workstudentMapper.donecount(sId);
    }

    @Override
    public int sumbystu(Integer sId) {
        return workstudentMapper.sumbystu(sId);
    }
}
