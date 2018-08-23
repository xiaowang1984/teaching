package com.neuedu.service.plan;

import com.neuedu.dao.PlanMapper;
import com.neuedu.pojo.Plan;
import com.neuedu.pojo.PlanExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PlanServiceImpl implements IplanService {
    @Resource
    PlanMapper planMapper;
    @Override
    public List<Plan> getPlans(Plan plan) {
        PlanExample planExample=new PlanExample();
        planExample.createCriteria().andCIdEqualTo(plan.getcId());
        return planMapper.selectByExample(planExample);
    }

    @Override
    public int add(Plan plan) {
        return planMapper.insertSelective(plan);
    }

    @Override
    public int edit(Plan plan) {

        return planMapper.updateByPrimaryKeySelective(plan);
    }

    @Override
    public int del(Plan plan) {
        return 0;
    }
}
