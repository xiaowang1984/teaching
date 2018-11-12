package com.neuedu.service.workdetails;

import com.neuedu.dao.WorkdetailsMapper;
import com.neuedu.pojo.Workdetails;
import com.neuedu.pojo.WorkdetailsExample;
import com.neuedu.service.work.IworkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WorkDetailsService implements IworkDetailsService {
    @Resource
    WorkdetailsMapper workdetailsMapper;
    @Override
    public int add(Workdetails workdetails) {
        return workdetailsMapper.insertSelective(workdetails);
    }

    @Override
    public List<Workdetails> getWorkDetails(Integer cId) {
        WorkdetailsExample workdetailsExample = new WorkdetailsExample();
        workdetailsExample.createCriteria().andCIdEqualTo(cId);
        workdetailsExample.setOrderByClause("status asc");
        return workdetailsMapper.selectByExampleWithBLOBs(workdetailsExample);
    }
}
