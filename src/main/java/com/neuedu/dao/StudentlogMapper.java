package com.neuedu.dao;

import com.neuedu.pojo.Studentlog;
import com.neuedu.pojo.StudentlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentlogMapper {
    int countByExample(StudentlogExample example);

    int deleteByExample(StudentlogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Studentlog record);

    int insertSelective(Studentlog record);

    List<Studentlog> selectByExampleWithBLOBs(StudentlogExample example);

    List<Studentlog> selectByExample(StudentlogExample example);

    Studentlog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Studentlog record, @Param("example") StudentlogExample example);

    int updateByExampleWithBLOBs(@Param("record") Studentlog record, @Param("example") StudentlogExample example);

    int updateByExample(@Param("record") Studentlog record, @Param("example") StudentlogExample example);

    int updateByPrimaryKeySelective(Studentlog record);

    int updateByPrimaryKeyWithBLOBs(Studentlog record);

    int updateByPrimaryKey(Studentlog record);
}