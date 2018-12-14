package com.neuedu.service.studentlog;

import com.neuedu.pojo.Student;
import com.neuedu.pojo.Studentlog;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

public interface IstudentLogService {
    int add(Studentlog studentlog);
    int update(Studentlog studentlog);
    Studentlog getStudentLogBySid(Studentlog studentlog);
    int save(Studentlog studentlog,HttpSession session);
    List<Studentlog> getLogs(int year,int month,int sId);
    List<Student> getLogsByGid(Date strt, Date end, int gId);
}
