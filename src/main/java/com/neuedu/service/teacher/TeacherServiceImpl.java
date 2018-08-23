package com.neuedu.service.teacher;

import com.github.pagehelper.PageHelper;
import com.neuedu.dao.TeacherMapper;
import com.neuedu.pojo.Teacher;
import com.neuedu.pojo.TeacherExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TeacherServiceImpl implements IteacherService {
    @Resource
    TeacherMapper teacherMapper;
    @Override
    public Teacher login(String no) {
        TeacherExample teacherExample=new TeacherExample();
        teacherExample.createCriteria().andNoEqualTo(no).andIsDelEqualTo(1);
        List<Teacher> teachers=teacherMapper.selectByExample(teacherExample);
        return teachers.size()>0?teachers.get(0):null;
    }

    @Override
    public List<Teacher> getTeacher(Teacher teacher) {
        TeacherExample teacherExample=new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        if(teacher.getType()!=null)
            criteria.andTypeEqualTo(teacher.getType());
        if(StringUtils.isNotBlank(teacher.getName()))
            criteria.andNameLike("%"+teacher.getName()+"%");
        if(teacher.getWithPage()==1)
            PageHelper.startPage(teacher.getPageNo(),teacher.getPageSize());
        return teacherMapper.selectByExample(teacherExample);
    }

    @Override
    public int add(Teacher teacher) {
        return teacherMapper.insertSelective(teacher);
    }

    @Override
    public Teacher getTeacherById(int id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherMapper.updateByPrimaryKeySelective(teacher);
    }
}
