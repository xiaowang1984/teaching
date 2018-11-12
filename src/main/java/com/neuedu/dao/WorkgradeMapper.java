package com.neuedu.dao;

import com.neuedu.pojo.Workgrade;
import com.neuedu.pojo.WorkgradeExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkgradeMapper {
    int countByExample(WorkgradeExample example);

    int deleteByExample(WorkgradeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Workgrade record);

    int insertSelective(Workgrade record);

    List<Workgrade> selectByExample(WorkgradeExample example);

    Workgrade selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Workgrade record, @Param("example") WorkgradeExample example);

    int updateByExample(@Param("record") Workgrade record, @Param("example") WorkgradeExample example);

    int updateByPrimaryKeySelective(Workgrade record);

    int updateByPrimaryKey(Workgrade record);

    int batchload(Date date);

    List<Workgrade> getlast(int wId);
}