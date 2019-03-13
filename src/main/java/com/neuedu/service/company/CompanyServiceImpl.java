package com.neuedu.service.company;

import com.github.pagehelper.PageHelper;
import com.neuedu.dao.CompanyMapper;
import com.neuedu.pojo.Company;
import com.neuedu.pojo.CompanyExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyServiceImpl implements IcompanyService {
    @Resource
    CompanyMapper companyMapper;
    @Override
    public List<Company> getCompany(Company company) {
        CompanyExample companyExample = new CompanyExample();
        if(company.getIsDel()!=null)
            companyExample.createCriteria().andIsDelEqualTo(company.getIsDel());
        if(company.getWithPage()==1)
            PageHelper.startPage(company.getPageNo(),company.getPageSize() );
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
}
