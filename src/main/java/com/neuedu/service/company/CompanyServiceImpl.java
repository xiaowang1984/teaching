package com.neuedu.service.company;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.dao.CompanyMapper;
import com.neuedu.pojo.Company;
import com.neuedu.pojo.CompanyExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class CompanyServiceImpl implements IcompanyService {
    @Resource
    CompanyMapper companyMapper;

    @Override
    public List<Company> getCompany(Company company) {
        CompanyExample companyExample = new CompanyExample();
        CompanyExample.Criteria criteria = companyExample.createCriteria();
        if (company.getIsDel() != null)
            criteria.andIsDelEqualTo(company.getIsDel());
        if (company.getWithPage() == 1)
            PageHelper.startPage(company.getPageNo(), company.getPageSize());
        if(StringUtils.isNotBlank(company.getName())){
            criteria.andNameLike("%"+company.getName()+"%");
        }
        return companyMapper.selectByExample(companyExample);

    }

    @Override
    public int add(Company company) {
        return companyMapper.insertSelective(company);
    }

    @Override
    public int update(Company company) {
        return companyMapper.updateByPrimaryKeySelective(company);
    }


    @Override
    public Company getCompanyById(Integer id) {
        return companyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int count(String name) {
        CompanyExample companyExample = new CompanyExample();
        companyExample.createCriteria().andNameEqualTo(name.trim());
        return companyMapper.countByExample(companyExample);
    }

    /*==============================zhangxin=2019.4.3========================================*/

    //模糊查询公司数据
    @Override
    public ServerResponse fuzzySearchByName(Integer pageNum,Integer pageSize,String keyName) {

        ServerResponse sr = null;

        //参数非空判断 100
        if(keyName == null || keyName.equals("")){
            sr = ServerResponse.createServerResponseByError(Const.JobListEnum.PARAM_NULL.getCode(),Const.JobListEnum.PARAM_NULL.getDesc());
            return sr;
        }

        //参数处理
        keyName = "%"+keyName+"%";

        //获取公司数据，并分页处理
        PageHelper.startPage(pageNum,pageSize);
        List<Company> lico = companyMapper.fuzzySearchByName(keyName);

        //没有查到相关数据 301
        if(lico == null || lico.size() == 0){
            sr = ServerResponse.createServerResponseByError(Const.JobListEnum.MSG_NULL.getCode(),Const.JobListEnum.MSG_NULL.getDesc());
            return sr;
        }

        //成功返回数据
        PageInfo pi = new PageInfo(lico,4);
        //这里对返回数据处理成Result,可以保障前端分页数据不出问题

        sr = ServerResponse.createServerResponseBySuccess(pi);

        return sr;
    }
}