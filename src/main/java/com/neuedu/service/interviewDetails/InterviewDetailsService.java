package com.neuedu.service.interviewDetails;

import com.neuedu.pojo.Interview;
import com.neuedu.pojo.InterviewDetails;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface InterviewDetailsService {
    List<InterviewDetails> getInterviewDetailsByIid(int iId);
    int add(InterviewDetails interviewDetails);
    int update(InterviewDetails interviewDetails);
    int save(InterviewDetails interviewDetails);
    InterviewDetails getInterviewDetailsBySidAndIid(InterviewDetails interviewDetails);
    int countByStudent(Integer sId);
    List<InterviewDetails> getInterviewDetailsBySid(Integer sId);
    Map<String,BigDecimal> avgbySid(Integer sId);
    Map<String,BigDecimal> avggrade(Integer sId);
}
