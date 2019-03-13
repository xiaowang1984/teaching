package com.neuedu.service.report;

import com.neuedu.pojo.Moodday;

import java.util.Date;
import java.util.List;

public interface IreportService {
    List<Moodday> getMooddays(Moodday moodday,Date end);
}
