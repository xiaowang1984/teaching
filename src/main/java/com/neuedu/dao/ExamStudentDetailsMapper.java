package com.neuedu.dao;

import com.neuedu.pojo.ExamStudentDetails;
import com.neuedu.pojo.ExamStudentDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamStudentDetailsMapper {
    int countByExample(ExamStudentDetailsExample example);

    int deleteByExample(ExamStudentDetailsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExamStudentDetails record);

    int insertSelective(ExamStudentDetails record);

    List<ExamStudentDetails> selectByExample(ExamStudentDetailsExample example);

    ExamStudentDetails selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExamStudentDetails record, @Param("example") ExamStudentDetailsExample example);

    int updateByExample(@Param("record") ExamStudentDetails record, @Param("example") ExamStudentDetailsExample example);

    int updateByPrimaryKeySelective(ExamStudentDetails record);

    int updateByPrimaryKey(ExamStudentDetails record);
}