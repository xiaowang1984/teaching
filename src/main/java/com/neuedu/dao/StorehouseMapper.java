package com.neuedu.dao;

import com.neuedu.pojo.Storehouse;
import com.neuedu.pojo.StorehouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorehouseMapper {
    int countByExample(StorehouseExample example);

    int deleteByExample(StorehouseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Storehouse record);

    int insertSelective(Storehouse record);

    List<Storehouse> selectByExampleWithBLOBs(StorehouseExample example);

    List<Storehouse> selectByExample(StorehouseExample example);

    Storehouse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Storehouse record, @Param("example") StorehouseExample example);

    int updateByExampleWithBLOBs(@Param("record") Storehouse record, @Param("example") StorehouseExample example);

    int updateByExample(@Param("record") Storehouse record, @Param("example") StorehouseExample example);

    int updateByPrimaryKeySelective(Storehouse record);

    int updateByPrimaryKeyWithBLOBs(Storehouse record);

    int updateByPrimaryKey(Storehouse record);

    int increment(int id);

    int decrement(int id);
}