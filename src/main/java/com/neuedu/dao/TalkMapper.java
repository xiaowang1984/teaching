package com.neuedu.dao;

import com.neuedu.pojo.Talk;
import com.neuedu.pojo.TalkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TalkMapper {
    int countByExample(TalkExample example);

    int deleteByExample(TalkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Talk record);

    int insertSelective(Talk record);

    List<Talk> selectByExampleWithBLOBs(TalkExample example);

    List<Talk> selectByExample(TalkExample example);

    Talk selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Talk record, @Param("example") TalkExample example);

    int updateByExampleWithBLOBs(@Param("record") Talk record, @Param("example") TalkExample example);

    int updateByExample(@Param("record") Talk record, @Param("example") TalkExample example);

    int updateByPrimaryKeySelective(Talk record);

    int updateByPrimaryKeyWithBLOBs(Talk record);

    int updateByPrimaryKey(Talk record);
}