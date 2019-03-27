package com.neuedu.service.workgrade;

import com.neuedu.dao.WorkgradeMapper;
import com.neuedu.pojo.Work;
import com.neuedu.pojo.Workgrade;
import com.neuedu.pojo.WorkgradeExample;
import com.neuedu.service.work.IworkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WorkGradeServiceImpl implements IworkGradeService{
    @Resource
    WorkgradeMapper workgradeMapper;
    @Resource
    IworkService workService;
    @Override
    public List<Workgrade> list(int wId) {
        WorkgradeExample workgradeExample = new WorkgradeExample();
        workgradeExample.createCriteria().andWIdEqualTo(wId);
        workgradeExample.setOrderByClause("dat asc");
        return workgradeMapper.selectByExample(workgradeExample);
    }
    @Override
    public int getCountByWid(int wId){
       return workgradeMapper.getCountByWid(wId);
    }

    @Override
    public List<Workgrade> workReport(Integer gId,Date start,Date end) {
        List<Work> works = workService.getListByGid(gId);
        if(works.size()==0)
            return new ArrayList<Workgrade>();
        List<Integer> wids=new ArrayList<>();
        for(Work work : works)
            wids.add(work.getId());
        WorkgradeExample workgradeExample = new WorkgradeExample();
        workgradeExample.createCriteria().andWIdIn(wids).
                andDatBetween(start,end );
        return workgradeMapper.selectByExample(workgradeExample);
    }
}
