package com.neuedu.service.workCommit;

import com.neuedu.dao.WorkcommitMapper;
import com.neuedu.pojo.Workcommit;
import com.neuedu.pojo.WorkcommitExample;
import com.neuedu.service.workdetails.IworkDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class WorkCommitServiceImpl implements IworkCommitService {
    @Resource
    WorkcommitMapper workcommitMapper;
    @Resource
    IworkDetailsService workDetailsService;
    @Override
    public int add(Workcommit workcommit) {
        return workcommitMapper.insertSelective(workcommit);
    }

    @Override
    public List<Workcommit> getWorkCommits(Workcommit workcommit) {
        WorkcommitExample workcommitExample = new WorkcommitExample();
        workcommitExample.createCriteria().andSIdEqualTo(workcommit.getsId()).andWIdEqualTo(workcommit.getwId()).andDatEqualTo(workcommit.getDat());
        List<Workcommit> workcommits = workcommitMapper.selectByExampleWithBLOBs(workcommitExample);
        for(Workcommit wcommit : workcommits)
            wcommit.setDetails(workDetailsService.getWorkDetails(wcommit.getId()));
        return workcommits;
    }

    @Override
    public List<Workcommit> getWorkCommitsByDat(Workcommit workcommit) {
        WorkcommitExample workcommitExample = new WorkcommitExample();
        workcommitExample.createCriteria().andWIdEqualTo(workcommit.getwId()).andDatEqualTo(workcommit.getDat());
        List<Workcommit> workcommits = workcommitMapper.selectByExampleWithBLOBs(workcommitExample);
        return workcommits;
    }
}
