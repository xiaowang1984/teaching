package com.neuedu.dao;

import com.neuedu.pojo.ArrangeList;
import com.neuedu.pojo.ArrangeListExample;
import com.neuedu.pojo.ArrangeListWithBLOBs;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArrangeListMapper {
    int countByExample(ArrangeListExample example);

    int deleteByExample(ArrangeListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArrangeListWithBLOBs record);

    int insertSelective(ArrangeListWithBLOBs record);

    List<ArrangeListWithBLOBs> selectByExampleWithBLOBs(ArrangeListExample example);

    List<ArrangeList> selectByExample(ArrangeListExample example);

    ArrangeListWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArrangeListWithBLOBs record, @Param("example") ArrangeListExample example);

    int updateByExampleWithBLOBs(@Param("record") ArrangeListWithBLOBs record, @Param("example") ArrangeListExample example);

    int updateByExample(@Param("record") ArrangeList record, @Param("example") ArrangeListExample example);

    int updateByPrimaryKeySelective(ArrangeListWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArrangeListWithBLOBs record);

    int updateByPrimaryKey(ArrangeList record);

    List<Date> getDatesByGid(int gId);

    List<Date> getDatesWithOutAid(int gId,int aId);
}