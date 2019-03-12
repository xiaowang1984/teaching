package com.neuedu.dao;

import com.neuedu.pojo.Workstudent;
import com.neuedu.pojo.WorkstudentExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    List<Date> getDatesBySid(Integer sId);

    List<Map<String,Object>> getStuCode(Map<String,Object> params);

    List<Workstudent> donecount(Integer sId);

    int sumbystu(Integer sId);
}