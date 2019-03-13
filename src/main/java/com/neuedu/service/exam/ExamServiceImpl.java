package com.neuedu.service.exam;

import com.neuedu.dao.ExamMapper;
import com.neuedu.pojo.ExamExample;
import com.neuedu.service.examDetails.IexamDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ExamServiceImpl implements IexamService {
    @Resource
    ExamMapper examMapper;
    @Resource
    IexamDetailsService examDetailsService;
    @Override
    public int countByStudent(Integer sId) {
        return examDetailsService.countByStudent(sId);
    }
}
