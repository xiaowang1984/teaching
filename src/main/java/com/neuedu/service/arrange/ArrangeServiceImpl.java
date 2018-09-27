package com.neuedu.service.arrange;


import com.neuedu.dao.ArrangeMapper;
import com.neuedu.pojo.Arrange;
import com.neuedu.pojo.ArrangeList;
import com.neuedu.pojo.ArrangeListWithBLOBs;
import com.neuedu.service.arrangeList.IarrangeListService;
import com.neuedu.service.grade.IgradeService;
import com.neuedu.service.plan.IplanService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ArrangeServiceImpl implements IarrangeService{
    @Resource
    ArrangeMapper arrangeMapper;
    @Resource
    IarrangeListService arrangeListService;
    @Resource
    IgradeService gradeService;
    @Resource
    IplanService planService;
    @Override
    @Transactional
    public int add(Arrange arrange,Date[] dates) {
        int  result;
        Arrays.sort(dates);
        arrange.setStartDate(dates[0]);
        arrange.setEndDate(dates[dates.length-1]);
        arrange.setIsDel(1);
        arrange.settId(gradeService.getGradeById(arrange.getgId()).getLecturer());
        if(arrange.getType().intValue()==1)
            arrange.setNote(planService.getPlanById(arrange.getpId()).getUrl());
        result=arrangeMapper.insertSelective(arrange);
        for (Date date : dates){
            ArrangeListWithBLOBs arrangeList=new ArrangeListWithBLOBs();
            arrangeList.setaId(arrange.getId());
            arrangeList.setDate(date);
            arrangeList.setIsDel(1);
            result=arrangeListService.add(arrangeList);
        }
        return result;
    }

    @Override
    @Transactional
    public int update(Arrange arrange, Date[] dates) {
        int result=0;
        Arrays.sort(dates);
        arrange.setStartDate(dates[0]);
        arrange.setEndDate(dates[dates.length-1]);
        result += arrangeMapper.updateByPrimaryKeySelective(arrange);
        result += arrangeListService.batchdel( arrange.getId());
        for (Date date : dates){
            ArrangeList arrangeList= arrangeListService.getArrangeListByDate(arrange.getId(), date);
            if(arrangeList != null) {
                result += arrangeListService.active(arrangeList);
            }else{
                ArrangeListWithBLOBs narrangeList = new ArrangeListWithBLOBs();
                narrangeList.setaId(arrange.getId());
                narrangeList.setDate(date);
                narrangeList.setIsDel(1);
                result += arrangeListService.add(narrangeList);
            }
        }
        return result;
    }

    @Override
    public Arrange getArrangeById(int id) {
        Arrange arrange = arrangeMapper.selectByPrimaryKey(id);
        arrange.setArrangeList(arrangeListService.getListByAid(arrange.getId()));
        return arrange;
    }
    @Override
    @Transactional
    public int del(Arrange arrange) {
        arrange.setIsDel(0);
        int result = arrangeMapper.updateByPrimaryKeySelective(arrange);
        ArrangeListWithBLOBs arrangeList = new ArrangeListWithBLOBs();
        arrangeList.setaId(arrange.getId());
        result += arrangeListService.del(arrangeList);
        return result;
    }
    @Override
    public List<Arrange> getArrangeByGid(int gId){
        return  null;
    }
}
