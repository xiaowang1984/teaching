package com.neuedu.service.grade;

import com.github.pagehelper.PageHelper;
import com.neuedu.core.Constants;
import com.neuedu.dao.GradeMapper;
import com.neuedu.dao.StudentMapper;
import com.neuedu.dao.TeacherMapper;
import com.neuedu.pojo.Arrange;
import com.neuedu.pojo.Course;
import com.neuedu.pojo.Grade;
import com.neuedu.pojo.GradeExample;
import com.neuedu.service.arrange.IarrangeService;
import com.neuedu.service.course.IcourseService;
import com.neuedu.service.employment.IemploymentService;
import com.neuedu.service.plan.IplanService;
import com.neuedu.service.student.IstudentService;
import com.neuedu.service.teacher.IteacherService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Case;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class GradeServiceImpl implements IgradeService {
    @Resource
    GradeMapper gradeMapper;
    @Resource
    IteacherService teacherService;
    @Resource
    IstudentService studentService;
    @Resource
    IarrangeService arrangeService;
    @Resource
    IcourseService courseService;
    @Resource
    IplanService planService;
    @Resource
    IemploymentService employmentService;
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
        if(grade.getIsDel()!=null)
            criteria.andIsDelEqualTo(grade.getIsDel());
        if(grade.getWithPage()==1){
            grade.setPageSize(20);
            PageHelper.startPage(grade.getPageNo(), grade.getPageSize());
        }
        gradeExample.setOrderByClause("start_date desc");
        List<Grade> grades=gradeMapper.selectByExample(gradeExample);
        for (Grade entry : grades){
            gradeDetails(entry);
            entry.setPlanImg(getLogo(entry.getId()));
        }
        return grades;
    }

    @Override
    public void gradeDetails(Grade grade) {
        grade.setLecturerName( teacherService.getTeacherById(grade.getLecturer()).getName());
        grade.setManagerName(teacherService.getTeacherById(grade.getManager()).getName());
        grade.setCount(studentService.count(grade.getId()));
        grade.setOffer(Integer.parseInt(employmentService.getClassONum(grade.getId()).getData().toString()));
    }

    @Override
    public Grade getGradeById(int id) {
        return gradeMapper.selectByPrimaryKey(id);
    }

    @Override
    public String getLogo(int id) {
        List<Arrange> arranges = arrangeService.getArrangeByGid(id);
        if(arranges.size()==0){
            return Constants.IMGSERVER+"logo/xxq.png";
        }else {
            Arrange arrange = arranges.get(0);
            return arrangeService.getLogo(arrange);
        }
    }

    @Override
    public Grade board(int gId) {
        Grade grade = getGradeById(gId);
        gradeDetails(grade);
        grade.setArranges(arrangeService.getBoard(gId));
        return grade;
    }
}
