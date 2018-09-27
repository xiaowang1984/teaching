package com.neuedu.service.arrangeList;

import com.neuedu.dao.ArrangeListMapper;
import com.neuedu.pojo.ArrangeList;
import com.neuedu.pojo.ArrangeListExample;
import com.neuedu.pojo.ArrangeListWithBLOBs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ArrangeListServiceImpl implements IarrangeListService {
    @Resource
    ArrangeListMapper arrangeListMapper;


    @Override
    public int add(ArrangeListWithBLOBs arrangeList) {
        return arrangeListMapper.insertSelective(arrangeList);
    }

    @Override
    public List<Date> getDates(int gId) {
        return arrangeListMapper.getDatesByGid(gId);
    }

    @Override
    public List<Date> getDates(int gId, int aId) {
        return arrangeListMapper.getDatesWithOutAid(gId,aId );
    }

    @Override
    public List<ArrangeListWithBLOBs> getListByAid(int aId) {
        ArrangeListExample arrangeListExample=new ArrangeListExample();
        arrangeListExample.setOrderByClause("date asc");
        arrangeListExample.createCriteria().andIsDelEqualTo(1).andAIdEqualTo(aId);
        return arrangeListMapper.selectByExampleWithBLOBs(arrangeListExample);
    }

    @Override
    public int batchdel(int aId) {
        ArrangeListWithBLOBs arrangeList = new ArrangeListWithBLOBs();
        ArrangeListExample arrangeListExample=new ArrangeListExample();
        arrangeListExample.createCriteria().andAIdEqualTo(aId);
        arrangeList.setIsDel(0);
        return arrangeListMapper.updateByExampleSelective(arrangeList, arrangeListExample);
    }

    @Override
    public int active(ArrangeList arrangeList) {
        arrangeList.setIsDel(1);
        return arrangeListMapper.updateByPrimaryKey(arrangeList);
    }

    @Override
    public ArrangeList getArrangeListByDate(int aId, Date date) {
        ArrangeListExample arrangeListExample=new ArrangeListExample();
        arrangeListExample.createCriteria().andAIdEqualTo(aId).andDateEqualTo(date);
        List<ArrangeList> list=arrangeListMapper.selectByExample(arrangeListExample);
        return list.size() == 0 ? null : list.get(0);
    }

    @Override
    public int del(ArrangeListWithBLOBs arrangeList) {
        ArrangeListExample arrangeListExample = new ArrangeListExample();
        arrangeListExample.createCriteria().andAIdEqualTo(arrangeList.getaId());
        arrangeList.setIsDel(0);
        return arrangeListMapper.updateByExampleSelective(arrangeList, arrangeListExample);
    }


}
