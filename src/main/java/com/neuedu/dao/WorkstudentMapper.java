package com.neuedu.dao;

import com.neuedu.pojo.Workstudent;
import com.neuedu.pojo.WorkstudentExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkstudentMapper {
    int countByExample(WorkstudentExample example);

    int deleteByExample(WorkstudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Workstudent record);

    int insertSelective(Workstudent record);

    List<Workstudent> selectByExample(WorkstudentExample example);

    Workstudent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Workstudent record, @Param("example") WorkstudentExample example);

    int updateByExample(@Param("record") Workstudent record, @Param("example") WorkstudentExample example);

    int updateByPrimaryKeySelective(Workstudent record);

    int updateByPrimaryKey(Workstudent record);

    int batchload(Date date);

    int checkcount(int wId);
}