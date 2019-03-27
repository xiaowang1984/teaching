package com.neuedu.service.arrange;


import com.neuedu.core.Constants;
import com.neuedu.dao.ArrangeMapper;
import com.neuedu.pojo.Arrange;
import com.neuedu.pojo.ArrangeExample;
import com.neuedu.pojo.ArrangeList;
import com.neuedu.pojo.ArrangeListWithBLOBs;
import com.neuedu.service.arrangeList.IarrangeListService;
import com.neuedu.service.course.IcourseService;
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
    @Resource
    IcourseService courseService;
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
        ArrangeExample example = new ArrangeExample();
        example.createCriteria().andGIdEqualTo(gId).andIsDelEqualTo(1);
        example.setOrderByClause("id desc");
        return  arrangeMapper.selectByExample(example);
    }

    @Override
    public List<Arrange> getBoard(int gId) {
        ArrangeExample example = new ArrangeExample();
        example.createCriteria().andGIdEqualTo(gId).andIsDelEqualTo(1);
        example.setOrderByClause("start_date asc");
        List<Arrange> arranges = arrangeMapper.selectByExample(example);
        for (Arrange arrange : arranges){
            arrange.setArrangeList(arrangeListService.getListByAid(arrange.getId()));
            arrange.setImg(getLogo(arrange));
            arrange.setPname(getPname(arrange));
        }
        return arranges;
    }

    @Override
    public String getLogo(Arrange arrange) {
        if (arrange.getType() == 0)
            return Constants.IMGSERVER + "logo/xxq.png";
        else if (arrange.getType() == 2)
            return Constants.IMGSERVER + "logo/xiangmu.png";
        else if (arrange.getType() == 3)
            return Constants.IMGSERVER + "logo/jiuye.png";
        else if (arrange.getType() == 4)
            return Constants.IMGSERVER + "logo/chuanjiang.png";
        else
            return Constants.IMGSERVER + courseService.getCourseById(planService.getPlanById(arrange.getpId()).getcId()).getImg();
    }

    @Override
    public String getPname(Arrange arrange) {
        if (arrange.getType() == 0)
            return "小学期";
        else if (arrange.getType() == 2)
            return "项目阶段";
        else if (arrange.getType() == 3)
            return "就业课";
        else if (arrange.getType() == 4)
            return "串讲复习";
        else
            return planService.getPlanById(arrange.getpId()).getName();
    }
}
