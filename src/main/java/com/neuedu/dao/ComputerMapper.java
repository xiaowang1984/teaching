package com.neuedu.dao;

import com.neuedu.pojo.Computer;
import com.neuedu.pojo.ComputerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComputerMapper {
    int countByExample(ComputerExample example);

    int deleteByExample(ComputerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Computer record);

    int insertSelective(Computer record);

    List<Computer> selectByExampleWithBLOBs(ComputerExample example);

    List<Computer> selectByExample(ComputerExample example);

    Computer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Computer record, @Param("example") ComputerExample example);

    int updateByExampleWithBLOBs(@Param("record") Computer record, @Param("example") ComputerExample example);

    int updateByExample(@Param("record") Computer record, @Param("example") ComputerExample example);

    int updateByPrimaryKeySelective(Computer record);

    int updateByPrimaryKeyWithBLOBs(Computer record);

    int updateByPrimaryKey(Computer record);
}