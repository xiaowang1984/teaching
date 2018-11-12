package com.neuedu.service.workgrade;

import com.neuedu.dao.WorkgradeMapper;
import com.neuedu.pojo.Workgrade;
import com.neuedu.pojo.WorkgradeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WorkGradeServiceImpl implements IworkGradeService{
    @Resource
    WorkgradeMapper workgradeMapper;
    @Override
    public List<Workgrade> list(int wId) {
        WorkgradeExample workgradeExample = new WorkgradeExample();
        workgradeExample.createCriteria().andWIdEqualTo(wId);
        workgradeExample.setOrderByClause("dat asc");
        return workgradeMapper.selectByExample(workgradeExample);
    }
    @Override
    public Workgrade getLast(int wId){
       List<Workgrade> workgrades= workgradeMapper.getlast(wId);
       if(workgrades.size()>0)
           return workgrades.get(0);
       else
           return null;
    }
}
