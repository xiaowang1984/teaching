package com.neuedu.service.interviewDetails;

import com.neuedu.dao.InterviewDetailsMapper;
import com.neuedu.dao.InterviewMapper;
import com.neuedu.pojo.InterviewDetails;
import com.neuedu.pojo.InterviewDetailsExample;
import com.neuedu.service.interview.InterviewService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class InterviewDetailsServiceImpl implements InterviewDetailsService {

    @Resource
    InterviewDetailsMapper interviewDetailsMapper;
    @Resource
    InterviewService interviewService;
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

    @Override
    public int countByStudent(Integer sId) {
        InterviewDetailsExample interviewDetailsExample = new InterviewDetailsExample();
        interviewDetailsExample.createCriteria().andSIdEqualTo(sId).andIsDelEqualTo(1);
        return interviewDetailsMapper.countByExample(interviewDetailsExample);
    }

    @Override
    public List<InterviewDetails> getInterviewDetailsBySid(Integer sId) {
        InterviewDetailsExample interviewDetailsExample = new InterviewDetailsExample();
        interviewDetailsExample.createCriteria().andSIdEqualTo(sId).andIsDelEqualTo(1);
        List<InterviewDetails> interviewDetails = interviewDetailsMapper.selectByExampleWithBLOBs(interviewDetailsExample);
        for(InterviewDetails details : interviewDetails){
            details.setInterview(interviewService.getInterViewById(details.getiId()));
            Map<String,BigDecimal> map = interviewDetailsMapper.avgexam(details.getiId());
            details.setAvgexpress(map.get("avgexpress"));
            details.setAvgskill(map.get("avgskill"));
        }
        return interviewDetails;
    }

    @Override
    public Map<String, BigDecimal> avgbySid(Integer sId) {
        return interviewDetailsMapper.avgbySid(sId);
    }

    @Override
    public Map<String, BigDecimal> avggrade(Integer sId) {
        return interviewDetailsMapper.avggrade(sId);
    }
}
