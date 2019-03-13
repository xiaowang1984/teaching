package com.neuedu.dao;

import com.neuedu.pojo.Employment;
import com.neuedu.pojo.EmploymentExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.neuedu.pojo.EmploymentParams;
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
}