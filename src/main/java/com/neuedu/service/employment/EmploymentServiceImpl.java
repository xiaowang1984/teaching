package com.neuedu.service.employment;

import com.neuedu.dao.EmploymentMapper;
import com.neuedu.message.Message;
import com.neuedu.pojo.Company;
import com.neuedu.pojo.Employment;
import com.neuedu.pojo.EmploymentExample;
import com.neuedu.pojo.EmploymentParams;
import com.neuedu.service.company.IcompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class EmploymentServiceImpl implements IemploymentService {
    @Resource
    EmploymentMapper employmentMapper;
    @Resource
    IcompanyService companyService;
    @Override
    public int add(Employment employment) {
        if(companyService.count(employment.getcName())==0){
            Company company = new Company();
            company.setName(employment.getcName());
            companyService.add(company);
        }
        return employmentMapper.insertSelective(employment);
    }

    @Override
    public List<Employment> list(Integer sId) {
        EmploymentExample employmentExample = new EmploymentExample();
        employmentExample.createCriteria().andSIdEqualTo(sId).andIsDelEqualTo(1);
        return employmentMapper.selectByExample(employmentExample);
    }

    @Override
    public Employment getEmploymentById(Integer id) {
        return employmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Employment employment) {
        return employmentMapper.updateByPrimaryKeySelective(employment);
    }

    @Override
    public int check(Employment employment) {
        int result=0;
        employment.setChoice(1);
        result += employmentMapper.updateByPrimaryKeySelective(employment);
        Employment query = getEmploymentById(employment.getId());
        Employment other = new Employment();
        other.setChoice(0);
        EmploymentExample employmentExample = new EmploymentExample();
        employmentExample.createCriteria().andSIdEqualTo(query.getsId()).andIdNotEqualTo(employment.getId());
        result += employmentMapper.updateByExampleSelective(other, employmentExample);
        return result;
    }

    @Override
    public List<Map<String, Object>> reportByGrade(EmploymentParams params) {
        return employmentMapper.reportByGrade(params);
    }

    @Override
    public List<Map<String, Object>> reportByStudent(int sId) {
        return employmentMapper.reportByStudent(sId);
    }
}
