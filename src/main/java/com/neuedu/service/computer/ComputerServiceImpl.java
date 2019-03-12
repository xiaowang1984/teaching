package com.neuedu.service.computer;

import com.github.pagehelper.PageHelper;
import com.neuedu.core.MyUtils;
import com.neuedu.dao.ComputerMapper;
import com.neuedu.pojo.Computer;
import com.neuedu.pojo.ComputerExample;
import com.neuedu.pojo.Score;
import com.neuedu.service.score.IscoreService;
import com.neuedu.service.storehouse.IstorehouseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.List;

@Service
public class ComputerServiceImpl implements IcomputerService {
    @Resource
    ComputerMapper computerMapper;
    @Resource
    IstorehouseService storehouseService;
    @Resource
    IscoreService scoreService;
    @Override
    public List<Computer> list(Computer computer) {
        ComputerExample storehouseExample = new ComputerExample();
        ComputerExample.Criteria criteria = storehouseExample.createCriteria();
        if(StringUtils.isNotBlank(computer.getName()))
            criteria.andNameLike("%"+computer.getName()+"%");
        if(computer.getcId()!=null)
            criteria.andCIdEqualTo(computer.getcId());
        if(computer.getIsDel()!=null)
            criteria.andIsDelEqualTo(computer.getIsDel());
        if(computer.getgId()!=null)
            criteria.andGIdEqualTo(computer.getgId());
        if(computer.getWithPage()==1)
            PageHelper.startPage(computer.getPageNo(), computer.getPageSize());
        List<Computer> computers =computerMapper.selectByExampleWithBLOBs(storehouseExample);
        for(Computer entry : computers){
            Score score = new Score();
            score.setcId(entry.getId());
            entry.setScores(scoreService.list(score));
        }
        return  computers;
    }
    @Override
    @Transactional
    public int add(Computer computer) {
        int result=0;
        result+=computerMapper.insertSelective(computer);
        result+=storehouseService.increment(computer.getsId());
        return result;
    }

    @Override
    public Computer getComputerById(int id) {
        Computer computer =computerMapper.selectByPrimaryKey(id);
        Score score = new Score();
        score.setcId(computer.getId());
        computer.setScores(scoreService.list(score));
        return computer;
    }

    @Override
    public int update(Computer computer) {
        return computerMapper.updateByPrimaryKeySelective(computer);
    }

    @Override
    public List<Computer> details(int year, int month, int gId) {
        ComputerExample computerExample = new ComputerExample();
        computerExample.createCriteria().andDatBetween(MyUtils.firstDate(year, month), MyUtils.endDate(year, month)).andGIdEqualTo(gId).andIsDelEqualTo(1);
        List<Computer> computers = computerMapper.selectByExampleWithBLOBs(computerExample);
        computerExample.setOrderByClause("dat asc");
        for(Computer computer : computers){
            Score score = new Score();
            score.setcId(computer.getId());
            computer.setScores(scoreService.list(score));
        }
        return computers;
    }

    @Override
    public int countByStudent(Integer sId) {
        return scoreService.countByStudent(sId);
    }
}
