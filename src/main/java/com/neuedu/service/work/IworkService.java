package com.neuedu.service.work;

import com.neuedu.pojo.Work;

import java.util.Date;
import java.util.List;

public interface IworkService {
    List<Work> list(Work work, Date dat);
    int add(Work work);
    int update(Work work);
    Work getWorkById(int id);
}
