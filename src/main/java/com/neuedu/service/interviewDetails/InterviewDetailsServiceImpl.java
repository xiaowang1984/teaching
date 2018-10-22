package com.neuedu.service.interviewDetails;

import com.neuedu.dao.InterviewDetailsMapper;
import com.neuedu.dao.InterviewMapper;
import com.neuedu.pojo.InterviewDetails;
import com.neuedu.pojo.InterviewDetailsExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InterviewDetailsServiceImpl implements InterviewDetailsService {

    @Resource
    InterviewDetailsMapper interviewDetailsMapper;
    @Override
    public List<InterviewDetails> getInterviewDetailsByIid(int iId) {
        InterviewDetailsExample example = new InterviewDetailsExample();
        example.createCriteria().andIIdEqualTo(iId);
        return interviewDetailsMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public int add(InterviewDetails interviewDetails) {
        return interviewDetailsMapper.insertSelective(interviewDetails);
    }

    @Override
    public int update(InterviewDetails interviewDetails) {
        InterviewDetailsExample example = new InterviewDetailsExample();
        example.createCriteria().andIIdEqualTo(interviewDetails.getiId()).andSIdEqualTo(interviewDetails.getsId());
        return interviewDetailsMapper.updateByExampleSelective(interviewDetails, example);
    }

    @Override
    @Transactional
    public int save(InterviewDetails interviewDetails) {
        InterviewDetails entry = getInterviewDetailsBySidAndIid(interviewDetails);
        int result = 0;
        if(entry == null){
            result = add(interviewDetails);
        }else{
            result = update(interviewDetails);
        }
        return result;
    }

    @Override
    public InterviewDetails getInterviewDetailsBySidAndIid(InterviewDetails interviewDetails) {
        InterviewDetailsExample example = new InterviewDetailsExample();
        example.createCriteria().andIIdEqualTo(interviewDetails.getiId()).andSIdEqualTo(interviewDetails.getsId());
        List<InterviewDetails> list = interviewDetailsMapper.selectByExampleWithBLOBs(example);
        return list.size()>0?list.get(0):null;
    }
}
