package com.neuedu.service.employment;

import com.neuedu.common.ServerResponse;
import com.neuedu.message.Message;
import com.neuedu.pojo.Employment;
import com.neuedu.pojo.EmploymentParams;
import com.neuedu.vo.ParmaVOAll;
import com.neuedu.vo.ParmaVODetil;

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

    /*================zhangxin===============*/
    //获取就业信息数据,以公司分类
    ServerResponse<Employment> getJoblist(Integer pageNum,Integer pageSize);
    //根据不同参数获取详细就业信息数据
    ServerResponse<Employment> getJoblistDetil(Integer pageNum,Integer pageSize,ParmaVODetil p);
    //根据公司名称获取就业信息数据
    ServerResponse<Employment> getJoblistCname(String c_name);

}
