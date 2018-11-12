package com.neuedu.service.studentlog;

import com.neuedu.core.MyUtils;
import com.neuedu.dao.StudentlogMapper;
import com.neuedu.pojo.Student;
import com.neuedu.pojo.StudentExample;
import com.neuedu.pojo.Studentlog;
import com.neuedu.pojo.StudentlogExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class StudentLogServiceImpl implements IstudentLogService {
    @Resource
    StudentlogMapper studentlogMapper;
    @Override
    public int add(Studentlog studentlog) {
        return studentlogMapper.insertSelective(studentlog);
    }

    @Override
    public int update(Studentlog studentlog) {
        return studentlogMapper.updateByPrimaryKeySelective(studentlog);
    }

    @Override
    public Studentlog getStudentLogBySid(Studentlog studentlog) {
        StudentlogExample studentlogExample = new StudentlogExample();
        studentlogExample.createCriteria().andSidEqualTo(studentlog.getSid()).andDatEqualTo(studentlog.getDat());
        List<Studentlog> studentlogs = studentlogMapper.selectByExampleWithBLOBs(studentlogExample);
        if(studentlogs.size()>0)
            return studentlogs.get(0);
        return null;
    }

    @Override
    public int save(Studentlog studentlog, HttpSession session) {
        Student student = (Student) session.getAttribute("user");
        studentlog.setSid(student.getId());
        Studentlog sl = getStudentLogBySid(studentlog);
        if(sl == null) {
            return add(studentlog);
        } else {
            studentlog.setId(sl.getId());
            return update(studentlog);
        }
    }

    @Override
    public List<Studentlog> getLogs(int year,int month, int sId) {
        int maxday=MyUtils.maxday(year, month);
        System.out.println(maxday);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, 1);
        Date start = calendar.getTime();
        calendar.set(year, month-1, maxday);
        Date end = calendar.getTime();
        StudentlogExample studentlogExample = new StudentlogExample();
        studentlogExample.createCriteria().andDatBetween(start, end).andSidEqualTo(sId);
        return studentlogMapper.selectByExampleWithBLOBs(studentlogExample);
    }
}
