package com.neuedu.dao;

import com.neuedu.pojo.Workcommit;
import com.neuedu.pojo.WorkcommitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkcommitMapper {
    int countByExample(WorkcommitExample example);

    int deleteByExample(WorkcommitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Workcommit record);

    int insertSelective(Workcommit record);

    List<Workcommit> selectByExampleWithBLOBs(WorkcommitExample example);

    List<Workcommit> selectByExample(WorkcommitExample example);

    Workcommit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Workcommit record, @Param("example") WorkcommitExample example);

    int updateByExampleWithBLOBs(@Param("record") Workcommit record, @Param("example") WorkcommitExample example);

    int updateByExample(@Param("record") Workcommit record, @Param("example") WorkcommitExample example);

    int updateByPrimaryKeySelective(Workcommit record);

    int updateByPrimaryKeyWithBLOBs(Workcommit record);

    int updateByPrimaryKey(Workcommit record);
}