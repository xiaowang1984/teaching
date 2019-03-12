package com.neuedu.dao;

import com.neuedu.pojo.InterviewDetails;
import com.neuedu.pojo.InterviewDetailsExample;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface InterviewDetailsMapper {
    int countByExample(InterviewDetailsExample example);

    int deleteByExample(InterviewDetailsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InterviewDetails record);

    int insertSelective(InterviewDetails record);

    List<InterviewDetails> selectByExampleWithBLOBs(InterviewDetailsExample example);

    List<InterviewDetails> selectByExample(InterviewDetailsExample example);

    InterviewDetails selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InterviewDetails record, @Param("example") InterviewDetailsExample example);

    int updateByExampleWithBLOBs(@Param("record") InterviewDetails record, @Param("example") InterviewDetailsExample example);

    int updateByExample(@Param("record") InterviewDetails record, @Param("example") InterviewDetailsExample example);

    int updateByPrimaryKeySelective(InterviewDetails record);

    int updateByPrimaryKeyWithBLOBs(InterviewDetails record);

    int updateByPrimaryKey(InterviewDetails record);

    Map<String,BigDecimal> avgexam(Integer id);

    Map<String,BigDecimal> avgbySid(Integer sId);

    Map<String,BigDecimal> avggrade(Integer sId);
}