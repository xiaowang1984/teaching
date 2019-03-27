package com.neuedu.dao;

import com.neuedu.pojo.Employment;
import com.neuedu.pojo.EmploymentExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.neuedu.pojo.EmploymentParams;
import com.neuedu.vo.JobListCompanyDetil;
import com.neuedu.vo.JobListVOCompany;
import com.neuedu.vo.ParmaVOAll;
import com.neuedu.vo.ParmaVODetil;
import org.apache.ibatis.annotations.Param;

public interface EmploymentMapper {
    int countByExample(EmploymentExample example);

    int deleteByExample(EmploymentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Employment record);

    int insertSelective(Employment record);

    List<Employment> selectByExample(EmploymentExample example);

    Employment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Employment record, @Param("example") EmploymentExample example);

    int updateByExample(@Param("record") Employment record, @Param("example") EmploymentExample example);

    int updateByPrimaryKeySelective(Employment record);

    int updateByPrimaryKey(Employment record);

    List<Map<String,Object>> reportByGrade(EmploymentParams employmentParams);

    List<Map<String,Object>> reportByStudent(int sId);

    /*=================zhangxin===============*/
    //获取就业信息数据
    List<Employment> selectAllJobs(ParmaVOAll p);

    //获取就业信息详情数据
    List<Employment> selectJobsDetil();

    //获取每家公司面试人数
    Integer selectJobNum(String cname);

    //获取每家公司offer人数
    Integer selectOfferNum(String cname);

    //获取每家公司平均薪资
    Double selectAvgMoney(String cname);

    //获取所有公司名称
    List<String> selectAllCompany();

    //参加该公司面试的人员详情
    List<JobListCompanyDetil> selectJobDetilByCname(ParmaVODetil p );
    //获取公司就业数据
    List<JobListVOCompany> selectAllJobByCompany();

    //判断公司是否存在
    int selectByCompany(String c_name);

    int selectByChoce(String cname);

}