package com.neuedu.service.cases;

import com.neuedu.pojo.Cases;

import java.util.List;

public interface IcaseService {
    int add(Cases cases);
    List<Cases> list(Cases cases);
    Cases getCaseById(int id);
    int update(Cases cases);
}
