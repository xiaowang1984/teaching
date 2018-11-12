package com.neuedu.dao;

import com.neuedu.pojo.Workdetails;
import com.neuedu.pojo.WorkdetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkdetailsMapper {
    int countByExample(WorkdetailsExample example);

    int deleteByExample(WorkdetailsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Workdetails record);

    int insertSelective(Workdetails record);

    List<Workdetails> selectByExampleWithBLOBs(WorkdetailsExample example);

    List<Workdetails> selectByExample(WorkdetailsExample example);

    Workdetails selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Workdetails record, @Param("example") WorkdetailsExample example);

    int updateByExampleWithBLOBs(@Param("record") Workdetails record, @Param("example") WorkdetailsExample example);

    int updateByExample(@Param("record") Workdetails record, @Param("example") WorkdetailsExample example);

    int updateByPrimaryKeySelective(Workdetails record);

    int updateByPrimaryKeyWithBLOBs(Workdetails record);

    int updateByPrimaryKey(Workdetails record);
}