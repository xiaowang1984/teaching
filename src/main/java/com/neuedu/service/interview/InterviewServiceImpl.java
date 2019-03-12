package com.neuedu.service.interview;

import com.neuedu.dao.InterviewDetailsMapper;
import com.neuedu.dao.InterviewMapper;
import com.neuedu.pojo.Interview;
import com.neuedu.pojo.InterviewDetailsExample;
import com.neuedu.pojo.InterviewExample;
import com.neuedu.service.interviewDetails.InterviewDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class InterviewServiceImpl implements InterviewService {
    @Resource
    InterviewMapper interviewMapper;
    @Resource
    InterviewDetailsService interviewDetailsService;
    @Override
    public int add(Interview interview) {
        return interviewMapper.insertSelective(interview);
    }

    @Override
    @Transactional
    public List<Interview> list(int gId) {
        InterviewExample example = new InterviewExample();
        example.createCriteria().andGIdEqualTo(gId).andIsDelEqualTo(1);
        example.setOrderByClause("id");
        List<Interview> list = interviewMapper.selectByExampleWithBLOBs(example);
        for (Interview interview : list){
            interview.setInterviewDetailsList(interviewDetailsService.getInterviewDetailsByIid(interview.getId()));
        }
        return list;
    }

    @Override
    public int update(Interview interview) {
        return interviewMapper.updateByPrimaryKeySelective(interview);
    }

    @Override
    public int countByStudent(Integer sId) {
        return interviewDetailsService.countByStudent(sId);
    }

    @Override
    public Interview getInterViewById(Integer id) {
        return interviewMapper.selectByPrimaryKey(id);
    }


}
