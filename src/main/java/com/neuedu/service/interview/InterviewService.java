package com.neuedu.service.interview;

import com.neuedu.pojo.Interview;

import java.util.List;

public interface InterviewService {
    int add(Interview interview);
    List<Interview> list(int gId);
    int update(Interview interview);
}
