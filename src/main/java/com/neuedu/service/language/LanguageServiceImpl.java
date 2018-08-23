package com.neuedu.service.language;

import com.neuedu.dao.LanguageMapper;
import com.neuedu.pojo.LanguageExample;
import com.neuedu.pojo.LanguageWithBLOBs;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LanguageServiceImpl implements IlanguageService {
    @Resource
    LanguageMapper languageMapper;
    @Override
    public List<LanguageWithBLOBs> getLanguages(LanguageWithBLOBs language) {
        LanguageExample languageExample=new LanguageExample();
        LanguageExample.Criteria criteria = languageExample.createCriteria();
        if(language!=null){
            if(StringUtils.isNotBlank(language.getName()))
                criteria.andNameLike("%"+language.getName()+"%");
            if(null!=language.getIsDel())
                criteria.andIsDelEqualTo(language.getIsDel());
        }
        return languageMapper.selectByExampleWithBLOBs(languageExample);
    }

    @Override
    public int add(LanguageWithBLOBs language) {
        return languageMapper.insertSelective(language);
    }

    @Override
    public int update(LanguageWithBLOBs language) {
        return languageMapper.updateByPrimaryKeySelective(language);
    }

    @Override
    public LanguageWithBLOBs getLanguageById(int id) {
        return languageMapper.selectByPrimaryKey(id);
    }
}
