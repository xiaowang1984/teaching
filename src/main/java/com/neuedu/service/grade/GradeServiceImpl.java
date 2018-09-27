package com.neuedu.service.grade;

import com.github.pagehelper.PageHelper;
import com.neuedu.dao.GradeMapper;
import com.neuedu.dao.StudentMapper;
import com.neuedu.dao.TeacherMapper;
import com.neuedu.pojo.Grade;
import com.neuedu.pojo.GradeExample;
import com.neuedu.service.student.IstudentService;
import com.neuedu.service.teacher.IteacherService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GradeServiceImpl implements IgradeService {
    @Resource
    GradeMapper gradeMapper;
    @Resource
    IteacherService teacherService;
    @Resource
    IstudentService studentService;
    @Override
    @Transactional
    public List<Grade> list(Grade grade) {
        GradeExample gradeExample = new GradeExample();
        GradeExample.Criteria criteria = gradeExample.createCriteria();
        if(grade.getType()!=null)
            criteria.andTypeEqualTo(grade.getType());
        if(grade.getLecturer()!=null)
            criteria.andLecturerEqualTo(grade.getLecturer());
        if(grade.getManager()!=null)
            criteria.andManagerEqualTo(grade.getManager());
        if(StringUtils.isNotBlank(grade.getName()))
            criteria.andNameLike("%"+grade.getName()+"%");
        if(grade.getWithPage()==1){
            grade.setPageSize(9);
            PageHelper.startPage(grade.getPageNo(), grade.getPageSize());
        }
        List<Grade> grades=gradeMapper.selectByExample(gradeExample);
        for (Grade entry : grades){
            gradeDetails(entry);
        }
        return grades;
    }

    @Override
    public void gradeDetails(Grade grade) {
        grade.setLecturerName( teacherService.getTeacherById(grade.getLecturer()).getName());
        grade.setManagerName(teacherService.getTeacherById(grade.getManager()).getName());
        grade.setCount(studentService.count(grade.getId()));
        grade.setOffer(studentService.offerCount(grade.getId()));
    }

    @Override
    public Grade getGradeById(int id) {
        return gradeMapper.selectByPrimaryKey(id);
    }

}
