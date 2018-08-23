package com.neuedu.dao;

import com.neuedu.pojo.Language;
import com.neuedu.pojo.LanguageExample;
import com.neuedu.pojo.LanguageWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LanguageMapper {
    int countByExample(LanguageExample example);

    int deleteByExample(LanguageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LanguageWithBLOBs record);

    int insertSelective(LanguageWithBLOBs record);

    List<LanguageWithBLOBs> selectByExampleWithBLOBs(LanguageExample example);

    List<Language> selectByExample(LanguageExample example);

    LanguageWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LanguageWithBLOBs record, @Param("example") LanguageExample example);

    int updateByExampleWithBLOBs(@Param("record") LanguageWithBLOBs record, @Param("example") LanguageExample example);

    int updateByExample(@Param("record") Language record, @Param("example") LanguageExample example);

    int updateByPrimaryKeySelective(LanguageWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LanguageWithBLOBs record);

    int updateByPrimaryKey(Language record);
}