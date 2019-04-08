package com.neuedu.service.company;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Company;

import java.util.List;

public interface IcompanyService {
    List<Company> getCompany(Company company);
    int add(Company company);
    int update(Company company);
    Company getCompanyById(Integer id);
    int count(String name);

    //模糊查询公司数据
    ServerResponse fuzzySearchByName(Integer pageNum,Integer pageSize,String keyName);
}
