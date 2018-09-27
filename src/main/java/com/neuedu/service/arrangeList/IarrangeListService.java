package com.neuedu.service.arrangeList;

import com.neuedu.pojo.Arrange;
import com.neuedu.pojo.ArrangeList;
import com.neuedu.pojo.ArrangeListWithBLOBs;

import java.util.Date;
import java.util.List;

public interface IarrangeListService {
    int add(ArrangeListWithBLOBs arrangeList);
    List<Date> getDates(int gId);
    List<Date> getDates(int gId,int aId);
    List<ArrangeListWithBLOBs> getListByAid(int aId);
    int batchdel(int aId);
    int active(ArrangeList arrangeList);
    ArrangeList getArrangeListByDate(int aId,Date date);
    int del(ArrangeListWithBLOBs arrangeList);
}
