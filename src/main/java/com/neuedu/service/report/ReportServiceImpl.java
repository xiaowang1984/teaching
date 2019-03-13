package com.neuedu.service.report;

import com.neuedu.dao.MooddayMapper;
import com.neuedu.pojo.Moodday;
import com.neuedu.pojo.MooddayExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements IreportService{
    @Resource
    MooddayMapper mooddayMapper;

    @Override
    public List<Moodday> getMooddays(Moodday moodday,Date end) {

        MooddayExample mooddayExample = new MooddayExample();
        mooddayExample.createCriteria().andGradeEqualTo(moodday.getGrade())
                .andDatBetween(moodday.getDat(), end);
        return mooddayMapper.selectByExample(mooddayExample);
    }
}
