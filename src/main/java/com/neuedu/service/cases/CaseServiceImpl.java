package com.neuedu.service.cases;

import com.github.pagehelper.PageHelper;
import com.google.common.base.Strings;
import com.neuedu.dao.CasesMapper;
import com.neuedu.pojo.Cases;
import com.neuedu.pojo.CasesExample;
import com.neuedu.pojo.Point;
import com.neuedu.service.point.IpointService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CaseServiceImpl implements IcaseService {
    @Resource
    CasesMapper casesMapper;
    @Resource
    IpointService pointService;
    @Override
    public int add(Cases cases) {
        return casesMapper.insertSelective(cases);
    }

    @Override
    public List<Cases> list(Cases cases) {
        CasesExample casesExample = new CasesExample();
        casesExample.setOrderByClause("id desc");
        CasesExample.Criteria criteria = casesExample.createCriteria();
        if(StringUtils.isNotBlank(cases.getName()))
            criteria.andNameLike("%"+cases.getName()+"%");
        if(StringUtils.isNotBlank(cases.getExtend()))
            criteria.andNameLike("%"+cases.getExtend()+"%");
        if(cases.getLanguage()!=null)
            criteria.andLanguageEqualTo(cases.getLanguage());
        if(cases.getType()!=null)
            criteria.andTypeEqualTo(cases.getType());
        if(cases.getIsDel()!=null)
            criteria.andIsDelEqualTo(cases.getIsDel());
        if(cases.getWithPage()==1)
            PageHelper.startPage(cases.getPageNo(), cases.getPageSize());
        return casesMapper.selectByExampleWithBLOBs(casesExample);
    }

    @Override
    public Cases getCaseById(int id) {
        Cases cases = casesMapper.selectByPrimaryKey(id);
        String[] split = cases.getPoint().split(",");
        int[] ids = new int[split.length];
        for (int i =0 ;i < split.length;i++)
            ids[i]=Integer.parseInt(split[i]);
        List<Point> points = pointService.getPointsByIds(ids);
        List<String> strs = new ArrayList<>();
        for(Point point : points){
            strs.add(point.getName());
        }
        cases.setPointNames(String.join(",",strs));
        return cases;
    }

    @Override
    public int update(Cases cases) {
        return casesMapper.updateByPrimaryKeySelective(cases);
    }
}
