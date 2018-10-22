package com.neuedu.service.interviewDetails;

import com.neuedu.pojo.Interview;
import com.neuedu.pojo.InterviewDetails;

import java.util.List;

public interface InterviewDetailsService {
    List<InterviewDetails> getInterviewDetailsByIid(int iId);
    int add(InterviewDetails interviewDetails);
    int update(InterviewDetails interviewDetails);
    int save(InterviewDetails interviewDetails);
    InterviewDetails getInterviewDetailsBySidAndIid(InterviewDetails interviewDetails);
}
