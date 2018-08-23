package com.neuedu.service.course;

import com.neuedu.dao.CourseMapper;
import com.neuedu.pojo.Course;
import com.neuedu.pojo.CourseExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServiceImpl implements IcourseService {
    @Resource
    CourseMapper courseMapper;
    @Override
    public List<Course> getCourse(Course course) {
        CourseExample courseExample=new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        if(course!=null){
            if(course.getIsDel()!=null)
                criteria.andIsDelEqualTo(course.getIsDel());
            if(StringUtils.isNotBlank(course.getName()))
                criteria.andNameLike("%"+course.getName()+"%");
        }
        if(StringUtils.isNotBlank(course.getName())){
            criteria.andNameLike("%"+course.getName()+"%");
        }
        return courseMapper.selectByExampleWithBLOBs(courseExample);
    }

    @Override
    public int add(Course course) {
        return courseMapper.insertSelective(course);
    }

    @Override
    public int edit(Course course) {
        return courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public Course getCourseById(int id) {
        return courseMapper.selectByPrimaryKey(id);
    }
}
