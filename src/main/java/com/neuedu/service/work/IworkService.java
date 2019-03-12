package com.neuedu.service.work;

import com.neuedu.pojo.Work;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IworkService {
    List<Work> list(Work work, Date dat);
    int add(Work work);
    int update(Work work);
    Work getWorkById(int id);
    Work getWorkByName(String name,int gId);
    void gitLoad(Map<String, String> parameterMap) throws ParseException;
    List<Work> getListByGid(int gId);
    List<Work> getListOne(int gId,int sId);
    int count(Integer gId);
}
