package com.neuedu.service.plan;

import com.neuedu.pojo.Plan;

import java.util.List;

public interface IplanService {
    List<Plan> getPlans(Plan plan);
    int add(Plan plan);
    int edit(Plan plan);
    int del(Plan plan);
}
