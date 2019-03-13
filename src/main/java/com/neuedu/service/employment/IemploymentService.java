package com.neuedu.service.employment;

import com.neuedu.message.Message;
import com.neuedu.pojo.Employment;
import com.neuedu.pojo.EmploymentParams;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IemploymentService {
    int add(Employment employment);
    List<Employment> list(Integer sId);
    Employment getEmploymentById(Integer id);
    int update(Employment employment);
    int check(Employment employment);
    List<Map<String,Object>> reportByGrade(EmploymentParams params);
    List<Map<String,Object>> reportByStudent(int sId);

}
