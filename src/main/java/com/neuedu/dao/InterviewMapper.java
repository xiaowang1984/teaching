package com.neuedu.dao;

import com.neuedu.pojo.Interview;
import com.neuedu.pojo.InterviewExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface InterviewMapper {
    int countByExample(InterviewExample example);

    int deleteByExample(InterviewExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Interview record);

    int insertSelective(Interview record);

    List<Interview> selectByExampleWithBLOBs(InterviewExample example);

    List<Interview> selectByExample(InterviewExample example);

    Interview selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Interview record, @Param("example") InterviewExample example);

    int updateByExampleWithBLOBs(@Param("record") Interview record, @Param("example") InterviewExample example);

    int updateByExample(@Param("record") Interview record, @Param("example") InterviewExample example);

    int updateByPrimaryKeySelective(Interview record);

    int updateByPrimaryKeyWithBLOBs(Interview record);

    int updateByPrimaryKey(Interview record);


}