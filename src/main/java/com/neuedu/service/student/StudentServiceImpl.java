package com.neuedu.service.student;

import com.neuedu.dao.StudentMapper;
import com.neuedu.pojo.Student;
import com.neuedu.pojo.StudentExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements IstudentService {
    @Resource
    StudentMapper studentMapper;
    @Override
    public Map<String,Object> list(Student student) {
        StudentExample studentExample=new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        if(student!=null){
            if(student.getgId()!=null)
                criteria.andGIdEqualTo(student.getgId());
            if(StringUtils.isNotBlank(student.getName()))
                criteria.andNameLike("%"+student.getName()+"%");
            if(student.getGender()!=null)
                criteria.andGenderEqualTo(student.getGender());
            if(student.getStatus()!=null)
                criteria.andStatusEqualTo(student.getStatus());
            criteria.andIsDelEqualTo(1);
        }
        studentExample.setOrderByClause("no asc");
        Map<String,Object> map=new HashMap<>();
        map.put("list", studentMapper.selectByExample(studentExample));
        map.put("count",studentMapper.countByExample(studentExample));
        return map;
    }
}
