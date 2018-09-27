package com.neuedu.dao;

import com.neuedu.pojo.Arrange;
import com.neuedu.pojo.ArrangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArrangeMapper {
    int countByExample(ArrangeExample example);

    int deleteByExample(ArrangeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Arrange record);

    int insertSelective(Arrange record);

    List<Arrange> selectByExample(ArrangeExample example);

    Arrange selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Arrange record, @Param("example") ArrangeExample example);

    int updateByExample(@Param("record") Arrange record, @Param("example") ArrangeExample example);

    int updateByPrimaryKeySelective(Arrange record);

    int updateByPrimaryKey(Arrange record);
}