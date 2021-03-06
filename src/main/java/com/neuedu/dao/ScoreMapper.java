package com.neuedu.dao;

import com.neuedu.pojo.Score;
import com.neuedu.pojo.ScoreExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScoreMapper {
    int countByExample(ScoreExample example);

    int deleteByExample(ScoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    List<Score> selectByExampleWithBLOBs(ScoreExample example);

    List<Score> selectByExample(ScoreExample example);

    Score selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExampleWithBLOBs(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKeyWithBLOBs(Score record);

    int updateByPrimaryKey(Score record);

    BigDecimal avgByCid(Integer cId);

    BigDecimal avgbySid(Integer sId);

    BigDecimal avggrade(Integer sId);
}