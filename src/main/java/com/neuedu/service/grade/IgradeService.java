package com.neuedu.service.grade;

import com.neuedu.pojo.Grade;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IgradeService {
    List<Grade> list(Grade grade);
    void gradeDetails(Grade grade);
    Grade getGradeById(int id);
    String getLogo(int id);
    Grade board(int gId);
}
