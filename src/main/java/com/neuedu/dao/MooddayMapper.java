package com.neuedu.dao;

import com.neuedu.pojo.Moodday;
import com.neuedu.pojo.MooddayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MooddayMapper {
    int countByExample(MooddayExample example);

    int deleteByExample(MooddayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Moodday record);

    int insertSelective(Moodday record);

    List<Moodday> selectByExample(MooddayExample example);

    Moodday selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Moodday record, @Param("example") MooddayExample example);

    int updateByExample(@Param("record") Moodday record, @Param("example") MooddayExample example);

    int updateByPrimaryKeySelective(Moodday record);

    int updateByPrimaryKey(Moodday record);
}