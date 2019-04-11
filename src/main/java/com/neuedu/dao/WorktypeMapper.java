package com.neuedu.dao;


import com.neuedu.pojo.Worktype;
import com.neuedu.pojo.WorktypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorktypeMapper {
    int countByExample(WorktypeExample example);

    int deleteByExample(WorktypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Worktype record);

    int insertSelective(Worktype record);

    List<Worktype> selectByExample(WorktypeExample example);

    Worktype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Worktype record, @Param("example") WorktypeExample example);

    int updateByExample(@Param("record") Worktype record, @Param("example") WorktypeExample example);

    int updateByPrimaryKeySelective(Worktype record);

    int updateByPrimaryKey(Worktype record);

    //查询所有数据
    List<Worktype> selectAll();

}