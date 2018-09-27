package com.neuedu.service.grade;

import com.neuedu.pojo.Grade;

import java.util.List;

public interface IgradeService {
    List<Grade> list(Grade grade);
    void gradeDetails(Grade grade);
    Grade getGradeById(int id);
}
