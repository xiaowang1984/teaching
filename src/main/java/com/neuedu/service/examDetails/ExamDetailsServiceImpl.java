package com.neuedu.service.examDetails;

import com.neuedu.dao.ExamDetailsMapper;
import com.neuedu.pojo.ExamDetailsExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ExamDetailsServiceImpl implements IexamDetailsService {
    @Resource
    ExamDetailsMapper examDetailsMapper;
    @Override
    public int countByStudent(Integer sId) {
        ExamDetailsExample examDetailsExample = new ExamDetailsExample();
        examDetailsExample.createCriteria().andSIdEqualTo(sId);
        return examDetailsMapper.countByExample(examDetailsExample);
    }
}
