package com.neuedu.dao;

import com.neuedu.pojo.MeetingDetail;
import com.neuedu.pojo.MeetingDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeetingDetailMapper {
    int countByExample(MeetingDetailExample example);

    int deleteByExample(MeetingDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MeetingDetail record);

    int insertSelective(MeetingDetail record);

    List<MeetingDetail> selectByExample(MeetingDetailExample example);

    MeetingDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MeetingDetail record, @Param("example") MeetingDetailExample example);

    int updateByExample(@Param("record") MeetingDetail record, @Param("example") MeetingDetailExample example);

    int updateByPrimaryKeySelective(MeetingDetail record);

    int updateByPrimaryKey(MeetingDetail record);
}