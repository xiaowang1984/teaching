package com.neuedu.controller;

import com.github.pagehelper.Page;
import com.neuedu.message.Message;
import com.neuedu.pojo.Company;
import com.neuedu.pojo.Result;
import com.neuedu.service.company.IcompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Resource
    IcompanyService companyService;
    @GetMapping("/list")
    public Result list(Company company){
        List<Company> list=companyService.getCompany(company);
        Result result=null;
        if(list instanceof Page)
            result = new Result(list, ((Page<Company>) list).getPages(),((Page<Company>) list).getPageNum() );
        else
            result = new Result(list, 1, 1);

        return result;
    }
    @GetMapping("/edit")
    public Company getCompanyById(Integer id){
        return companyService.getCompanyById(id);
    }
    @PostMapping("/edit")
    public Message update(Company company){
        return new Message(companyService.update(company));
    }
    @PostMapping("/add")
    public Message add(Company company){
        return new Message(companyService.add(company));
    }
}
