package com.neuedu.service.workdetails;

import com.neuedu.pojo.Workdetails;

import java.util.List;

public interface IworkDetailsService {
    int add (Workdetails workdetails);
    List<Workdetails> getWorkDetails(Integer cId);
}
