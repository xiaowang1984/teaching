package com.neuedu.service.workstudent;

import com.neuedu.pojo.Workstudent;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IworkstudentService {
    int batchload(Date date);
    List<Workstudent> list(int wId,int sId);
    int update(Workstudent workstudent);
    int checkcount(int wId);
    List<Date> getDatesBySid(Integer sId);
    List<Map<String,Object>> getStuCode(Integer sId,List<Date> dates);
    List<Workstudent> donecount(Integer sId);
    int sumbystu(Integer sId);
}
