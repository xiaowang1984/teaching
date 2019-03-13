package com.neuedu.dao;

import com.neuedu.pojo.ExamDetails;
import com.neuedu.pojo.ExamDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamDetailsMapper {
    int countByExample(ExamDetailsExample example);

    int deleteByExample(ExamDetailsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExamDetails record);

    int insertSelective(ExamDetails record);

    List<ExamDetails> selectByExample(ExamDetailsExample example);

    ExamDetails selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExamDetails record, @Param("example") ExamDetailsExample example);

    int updateByExample(@Param("record") ExamDetails record, @Param("example") ExamDetailsExample example);

    int updateByPrimaryKeySelective(ExamDetails record);

    int updateByPrimaryKey(ExamDetails record);
}