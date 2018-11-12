package com.neuedu.service.workstudent;

import com.neuedu.pojo.Workstudent;

import java.util.Date;
import java.util.List;

public interface IworkstudentService {
    int batchload(Date date);
    List<Workstudent> list(int wId,int sId);
    int update(Workstudent workstudent);
    int checkcount(int wId);
}
