package com.neuedu.service.interview;

import com.neuedu.pojo.Interview;

import java.util.List;
import java.util.Map;

public interface InterviewService {
    int add(Interview interview);
    List<Interview> list(int gId);
    int update(Interview interview);
    int countByStudent(Integer sId);
    Interview getInterViewById(Integer id);
}
